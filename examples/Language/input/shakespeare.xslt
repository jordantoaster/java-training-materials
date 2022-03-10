<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="PLAY">
		<html>
			<head>
				<title>Much Ado About Nothing</title>
				<style type="text/css">
					h2,h1,h3 { text-align: center; }
					table { border-collapse: collapse; border-color: black; }
					th { background:navy; color:white; border:thin solid; text-align: center; }
					td { background:white; color:black; border:thin solid; text-align: center; }
					.line {margin-left: 2em;}
					a.act {}
					a.scene {margin-left: 1em;}
				</style>
			</head>
			<body>
				<xsl:apply-templates select="TITLE | PERSONAE"/>
				
				<hr/>
				<h2>Acts and Scenes</h2>
				<hr/>
				<p>
					<xsl:for-each select="//ACT | //SCENE">
						<xsl:if test="self::ACT">
							<a class="act" href="#{generate-id(.)}"><xsl:value-of select="TITLE"/></a><br/>
						</xsl:if>
						<xsl:if test="self::SCENE">
							<a class="scene" href="#{generate-id(.)}"><xsl:value-of select="TITLE"/></a><br/>
						</xsl:if>
					</xsl:for-each>
				</p>
				
				<xsl:apply-templates select="ACT | SCNDESCR | PROLOG | EPILOGUE"/>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="PLAY/TITLE">
		<h1><xsl:value-of select="text()"/></h1>
	</xsl:template>
	
	<xsl:template match="PLAY/PERSONAE">
		<hr/>
		<h2><xsl:value-of select="TITLE"/></h2>
		<hr/>
		<table align="center">
			<tr>
				<th>Character</th><th>Description</th>
			</tr>
			<xsl:for-each select="PERSONA | PGROUP">
				<!-- If entry describes a single person -->
				<xsl:if test="local-name(.) = 'PERSONA'">
					<xsl:choose>
						<!-- If entry has a description -->
						<xsl:when test="contains(string(.),',')">
							<tr>
								<td><xsl:value-of select="substring-before(string(.),',')"/></td>
								<td><xsl:value-of select="substring-after(string(.),',')"/></td>
							</tr>
						</xsl:when>
						<!-- If entry does not have a description -->
						<xsl:otherwise>
							<tr>
								<td><xsl:value-of select="."/></td>
								<td></td>
							</tr>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:if>
				<!-- If entry describes a group of people -->
				<xsl:if test="local-name(.) = 'PGROUP'">
					<tr>
						<td>
							<xsl:for-each select="PERSONA">
								<xsl:value-of select="."/><br/>
							</xsl:for-each>
						</td>
						<td><xsl:value-of select="GRPDESCR"/></td>
					</tr>
				</xsl:if>
			</xsl:for-each>
		</table>
	</xsl:template>
	
	<xsl:template match="ACT">
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="ACT/TITLE">
		<hr/>
		<a name="{generate-id(..)}"><h2><xsl:value-of select="."/></h2></a>
		<hr/>
	</xsl:template>
	
	<xsl:template match="ACT/SCENE">
		<a name="{generate-id(.)}"><h3><xsl:value-of select="TITLE"/></h3></a>
		<xsl:apply-templates select="SPEECH | STAGEDIR"/>
	</xsl:template>
	
	<xsl:template match="SPEECH">
			<h4><xsl:value-of select="SPEAKER"/></h4>
			<p>
				<xsl:apply-templates/>
			</p>
	</xsl:template>
	
	<xsl:template match="SPEECH/SPEAKER"/>
	
	<xsl:template match="SPEECH/LINE">
		<div class="line"><xsl:value-of select="."/><br/></div>
	</xsl:template>
	
	<xsl:template match="FM"/>
	<xsl:template match="PLAYSUBT"/>
	
	<xsl:template match="SCNDESCR">
		<i>Scene Direction: <xsl:value-of select="."/></i>
	</xsl:template>
	
	<xsl:template match="STAGEDIR">
		<p>
			<i>Stage Direction: <xsl:value-of select="."/></i>
		</p>
	</xsl:template>


</xsl:stylesheet>
