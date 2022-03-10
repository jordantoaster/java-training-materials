package com.instil.resources

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.instil.model.Course
import com.instil.model.CourseDifficulty.*
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport
import io.dropwizard.testing.junit5.ResourceExtension
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import javax.ws.rs.client.Entity
import javax.ws.rs.core.MediaType

@ExtendWith(DropwizardExtensionsSupport::class)
class CoursesResourceTest {
    companion object {
        private val testData: MutableMap<String, Course> = HashMap()
        private val extension = ResourceExtension
            .builder()
            .addResource(CoursesResource(testData))
            .build()
    }

    @BeforeEach
    fun startup() {
        resetTestData()
    }

    @Test
    @Throws(JsonProcessingException::class)
    fun allCoursesCanBeFound() {
        val response = extension
            .target("/courses")
            .request()
            .get()

        assertEquals(200, response.getStatus())

        val json: String = response.readEntity(String::class.java)
        val results = convertJsonToCourseList(json)

        assertEquals(4, results.size)
        assertContainsCourse("AB12", results)
        assertContainsCourse("CD34", results)
        assertContainsCourse("EF56", results)
        assertContainsCourse("GH78", results)
    }

    @Test
    @Throws(JsonProcessingException::class)
    fun coursesCanBeFoundByType() {
        val response = extension
            .target("/courses")
            .queryParam("type", BEGINNER)
            .request()
            .get()

        assertEquals(200, response.status)

        val json = response.readEntity(String::class.java)
        val results = convertJsonToCourseList(json)

        assertContainsCourse("AB12", results)
        assertContainsCourse("GH78", results)
    }

    @Test
    fun coursesCanBeFoundByID() {
        val result = extension
            .target("/courses")
            .path("AB12")
            .request()
            .get(Course::class.java)

        assertEquals("AB12", result.id)
        assertEquals("Programming in Scala", result.title)
        assertEquals(BEGINNER, result.difficulty)
        assertEquals(4, result.duration)
    }

    @Test
    fun coursesCanBeRemoved() {
        val sampleID = "CD34"

        val deleteResult = extension
            .target("/courses")
            .path(sampleID)
            .request()
            .delete()

        assertEquals(200, deleteResult.getStatus())

        val getResult = extension
            .target("/courses/")
            .path(sampleID)
            .request()
            .get()

        assertEquals(404, getResult.getStatus())
    }

    @Test
    fun coursesCanBeAdded() {
        val newCourse = Course("YZ98", "Intro to Haskell", ADVANCED, 3)

        val putResult = extension
            .target("/courses")
            .path("YZ98")
            .request()
            .put(Entity.entity(newCourse, MediaType.APPLICATION_JSON_TYPE))

        assertEquals(204, putResult.getStatus())

        val getResult = extension
            .target("/courses")
            .path("YZ98")
            .request()
            .get(Course::class.java)

        assertEquals("YZ98", getResult.id)
        assertEquals("Intro to Haskell", getResult.title)
        assertEquals(ADVANCED, getResult.difficulty)
        assertEquals(3, getResult.duration)
    }

    private fun resetTestData() {
        val sampleValues = mapOf(
            "AB12" to Course("AB12", "Programming in Scala", BEGINNER, 4),
            "CD34" to Course("CD34", "Machine Learning in Python", INTERMEDIATE, 3),
            "EF56" to Course("EF56", "Advanced Kotlin Coding", ADVANCED, 2),
            "GH78" to Course("GH78", "Intro to Domain Driven Design", BEGINNER, 3)
        )
        testData.clear()
        testData.putAll(sampleValues)
    }

    private fun assertContainsCourse(id: String, results: List<Course>) {
        val result = results
            .stream()
            .anyMatch { c: Course -> c.id == id }

        assertTrue(result, "No course with id: $id")
    }

    @Throws(JsonProcessingException::class)
    private fun convertJsonToCourseList(json: String): List<Course> {
        val mapper = ObjectMapper()
        val typeRef = object : TypeReference<List<Course>>() {}
        return mapper.readValue(json, typeRef)
    }
}


