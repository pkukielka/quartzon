quartzon
========

Library for easy creation Quartz jobs and triggers directly from JSON

### Motivation
Although Quartz supports remote communication through RMI there is no easy way to create new jobs and triggers without using Java on the client side (for example from web browser using REST API).
Still, building your own communication channel would be quite easy job if there would be any method to serialize and deserialize Quartz objects. Unlucky, there is none.
Quartzon is aiming to fill this gap. It allows you to describe all your jobs and triggers using JSON.
Together with Java POJOs used for easy JSON deserialization it provides builders for automatic creation of Quartz jobs/triggers/schedulers.

### Schema
Classes design and naming were inspired by schema of JobInitializationPlugin: http://www.quartz-scheduler.org/xml/job_scheduling_data_2_0.xsd.
Because there is no very good established schema for JSON we will use xsd equivalent to show the data model:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xs:complexType name="scheduler">
    <xs:sequence>
      <xs:element name="cronTriggers" type="cronTrigger" nillable="true" minOccurs="0" maxOccurs="unbounded"/>
      <xs:element name="jobs" type="jobDetail" nillable="true" minOccurs="0" maxOccurs="unbounded"/>
      <xs:element name="processingDirectives" type="processingDirectives" minOccurs="0"/>
      <xs:element name="simpleTriggers" type="simpleTrigger" nillable="true" minOccurs="0" maxOccurs="unbounded"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="cronTrigger">
    <xs:complexContent>
      <xs:extension base="abstractTrigger">
        <xs:sequence>
          <xs:element name="cronExpression" type="xs:string" minOccurs="0"/>
          <xs:element name="misfireInstruction" type="xs:string" minOccurs="0"/>
          <xs:element name="timeZone" type="xs:string" minOccurs="0"/>
        </xs:sequence>
      </xs:extension>
    </xs:complexContent>
  </xs:complexType>

  <xs:complexType name="abstractTrigger" abstract="true">
    <xs:sequence>
      <xs:element name="calendarName" type="xs:string" minOccurs="0"/>
      <xs:element name="description" type="xs:string" minOccurs="0"/>
      <xs:element name="endTime" type="xs:dateTime" minOccurs="0"/>
      <xs:element name="group" type="xs:string" minOccurs="0"/>
      <xs:element name="jobDataMap" type="entry" nillable="true" minOccurs="0" maxOccurs="unbounded"/>
      <xs:element name="jobGroup" type="xs:string" minOccurs="0"/>
      <xs:element name="jobName" type="xs:string" minOccurs="0"/>
      <xs:element name="name" type="xs:string" minOccurs="0"/>
      <xs:element name="priority" type="xs:int" minOccurs="0"/>
      <xs:element name="startTime" type="xs:dateTime" minOccurs="0"/>
      <xs:element name="startTimeSecondsInFuture" type="xs:int" minOccurs="0"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="entry">
    <xs:sequence>
      <xs:element name="key" type="xs:string" minOccurs="0"/>
      <xs:element name="value" type="xs:string" minOccurs="0"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="jobDetail">
    <xs:sequence>
      <xs:element name="description" type="xs:string" minOccurs="0"/>
      <xs:element name="durability" type="xs:boolean" minOccurs="0"/>
      <xs:element name="group" type="xs:string" minOccurs="0"/>
      <xs:element name="jobClass" type="xs:string" minOccurs="0"/>
      <xs:element name="jobDataMap" type="entry" nillable="true" minOccurs="0" maxOccurs="unbounded"/>
      <xs:element name="name" type="xs:string" minOccurs="0"/>
      <xs:element name="recover" type="xs:boolean" minOccurs="0"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="processingDirectives">
    <xs:sequence>
      <xs:element name="ignoreDuplicates" type="xs:boolean" minOccurs="0"/>
      <xs:element name="overwriteExistingData" type="xs:boolean" minOccurs="0"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="simpleTrigger">
    <xs:complexContent>
      <xs:extension base="abstractTrigger">
        <xs:sequence>
          <xs:element name="misfireInstruction" type="xs:string" minOccurs="0"/>
          <xs:element name="repeatCount" type="xs:int" minOccurs="0"/>
          <xs:element name="repeatInterval" type="xs:int" minOccurs="0"/>
        </xs:sequence>
      </xs:extension>
    </xs:complexContent>
  </xs:complexType>
</xs:schema>
```

### Usage
_In progress_