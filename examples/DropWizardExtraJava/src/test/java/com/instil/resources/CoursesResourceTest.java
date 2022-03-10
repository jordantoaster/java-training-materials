package com.instil.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.instil.model.Course;
import com.instil.model.CourseDifficulty;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.instil.model.CourseDifficulty.ADVANCED;
import static com.instil.model.CourseDifficulty.BEGINNER;
import static java.util.Map.entry;
import static javax.ws.rs.client.Entity.entity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DropwizardExtensionsSupport.class)
public class CoursesResourceTest {

    private static final Map<String, Course> testData = new HashMap<>();
    private static final ResourceExtension extension = ResourceExtension
            .builder()
            .addResource(new CoursesResource(testData))
            .build();

    @BeforeEach
    public void startup() {
        resetTestData();
    }

    @Test
    public void allCoursesCanBeFound() throws JsonProcessingException {
        var response = extension
                .target("/courses")
                .request()
                .get();

        assertEquals(200, response.getStatus());

        var json = response.readEntity(String.class);
        List<Course> results = convertJsonToCourseList(json);

        assertEquals(4, results.size());
        assertContainsCourse("AB12", results);
        assertContainsCourse("CD34", results);
        assertContainsCourse("EF56", results);
        assertContainsCourse("GH78", results);
    }

    @Test
    public void coursesCanBeFoundByType() throws JsonProcessingException {
        var response = extension
                .target("/courses")
                .queryParam("type", BEGINNER)
                .request()
                .get();

        assertEquals(200, response.getStatus());

        var json = response.readEntity(String.class);
        List<Course> results = convertJsonToCourseList(json);

        assertContainsCourse("AB12", results);
        assertContainsCourse("GH78", results);
    }

    @Test
    public void coursesCanBeFoundByID() {
        var result = extension
                .target("/courses")
                .path("AB12")
                .request()
                .get(Course.class);

        assertEquals("AB12", result.getId());
        assertEquals("Programming in Scala", result.getTitle());
        assertEquals(BEGINNER, result.getDifficulty());
        assertEquals(4, result.getDuration());
    }

    @Test
    public void coursesCanBeRemoved() {
        var sampleID = "CD34";

        var deleteResult = extension
                .target("/courses")
                .path(sampleID)
                .request()
                .delete();

        assertEquals(200, deleteResult.getStatus());

        var getResult = extension
                .target("/courses/")
                .path(sampleID)
                .request()
                .get();

        assertEquals(404, getResult.getStatus());
    }

    @Test
    public void coursesCanBeAdded() {
        var newCourse = new Course("YZ98", "Intro to Haskell", ADVANCED, 3);

        var putResult = extension
                .target("/courses")
                .path("YZ98")
                .request()
                .put(entity(newCourse, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(204, putResult.getStatus());

        var getResult = extension
                .target("/courses")
                .path("YZ98")
                .request()
                .get(Course.class);

        assertEquals("YZ98", getResult.getId());
        assertEquals("Intro to Haskell", getResult.getTitle());
        assertEquals(ADVANCED, getResult.getDifficulty());
        assertEquals(3, getResult.getDuration());
    }

    private void resetTestData() {
        var sampleValues = Map.ofEntries(
                entry("AB12", new Course("AB12", "Programming in Scala", BEGINNER, 4)),
                entry("CD34", new Course("CD34", "Machine Learning in Python", CourseDifficulty.INTERMEDIATE, 3)),
                entry("EF56", new Course("EF56", "Advanced Kotlin Coding", CourseDifficulty.ADVANCED, 2)),
                entry("GH78", new Course("GH78", "Intro to Domain Driven Design", BEGINNER, 3))
        );

        testData.clear();
        testData.putAll(sampleValues);
    }

    private void assertContainsCourse(String id, List<Course> results) {
        final var result = results
                .stream()
                .anyMatch(c -> c.getId().equals(id));

        assertTrue(result, "No course with id: " + id);
    }

    private List<Course> convertJsonToCourseList(String json) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        var typeRef = new TypeReference<List<Course>>() {};
        return mapper.readValue(json, typeRef);
    }
}
