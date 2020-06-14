**A Summary of the AWS White Paper**

* * *

### The Five Pillars

When working with a distributed computing architecture there are five-pillars you should focus on in order for it to operate at the optimal capacity. Each pillar has it's own design principles and best practices from which to operate and AWS offers tools and services to help with the implementation of each principle. The pillars are as follows:

*   Operational Excellence
*   Security
*   Reliability
*   Performance Efficiency
*   Cost Optimization

For each of these I will do a brief overview of the design principles and the best practices as outlined by the white paper itself.

* * *

### Operational Excellence

#### Design Principles

*   Perform operation as code – Define entire environment and workload as code to reduce human error and enable consistent responses
*   Annotate Documentation – Automate the creation of documentation after every build
*   Refine operation procedures frequently- Always look for opportunities for improvement and evolve procedures to facilitate improvement
*   Make frequent, small reversible changes – Making small changes allows for components to be updated frequently
*   Anticipate Failure – Always test failure response procedures and perform exercises to identify sources of failure.
*   Learn from all operations failures- drive improvements through lessons learned

#### Best Practices

##### Prepare

*   Have shared goals and understanding across every part of the business
*   Design your system to monitor all aspects of the application, infrastructure and customer experience
*   Design method by to validate application is ready for production and to be supported by operations
*   Be sure to have sufficient trained personnel to support the workloads
*   Test and practice response to operational events and failures

##### Operate

*   Measure operational health and success by the achievement of business and customer outcomes using custom dashboards to manage expectations and inform of normal operations
*   Prioritize responses based on business and customer impact
*   Determine cause of unplanned events and update procedures to facilitate for them
*   Routine and responses to unplanned events should be automated

##### Evolve

*   Dedicate work cycles to continuous incremental improvements
*   Evaluate and prioritize improvement opportunities in both workload and operations procedures
*   Share lessons across to teams to share benefits
*   Make frequent small improvements with a safe environment from which to experiment, develop and test improvements

* * *

### Security

#### Design Principles

*   Implement a strong identity foundation by separating duties, giving individuals the least privilege needed, centralizing privilege management and reducing long-term credentials.
*   Enable traceability by monitoring, alerting and auditing all changes and integrating logs and metrics to respond.
*   Apply security at each layer of the application from the network to the operating system of each specific instance
*   Automate best practices
*   Protect data at data and at rest by limiting human interaction and classifying data into sensitivity levels using encryption and tokenization.
*   Prepare for security events and have an incident management process that aligns with organization requirements

#### Best Practices

*   Identity and Access Management – allow only authorized and authenticated users to access resources in only the manner intended (R/W/Execute)
*   Detective Controls – use to identify potential security incidents with reactive tools to identify and understand anomalous activity
*   Infrastructure Protection – Defend the infrastructure at all layers and enforce rules to increase security even further like Multi-Factor Authorization
*   Data Protection – Before designing a system define rules for data classification and encryption
*   Incident Response – Isolate and contain systems to restore operations to a good known state and routinely practice incident responses

* * *

### Reliability

#### Design Principles

*   Use automation in the cloud to simulate and recreate failures then test recovery procedures
*   Automatically recover from failure by monitoring system for key performance indicators and triggering recovery mechanisms when certain thresholds are breached
*   Scale horizontally to increase aggregate system availability by distributing requests across several smaller resources so one point of failure has a smaller impact on the overall system
*   Stop guessing capacity and automate addition and removal of resources
*   Manage changes to the system using automation

#### Best Practices

*   Foundations – set foundational requirements that influence reliability before architecting a system, understand that cloud is limitless and that limits for networking and computing capacity may change over time
*   Change Management – Monitor trends that could lead to capacity issues and add or remove resources as needed using automated responses to key performance indicators to increase reliability and ensure that business success doesn’t become a burden
*   Failure Management – Automate reactions to monitoring data, perform regular backups and test backups to cause failures and ensure you can recover from physical and logical errors

* * *

### Perfomance Efficiency

#### Design Principles

*   Democratize advance technologies by pushing them onto the cloud and using them as a service rather than trying to learn to host and run it

*   Use serverless architectures to remove the need to run and maintain servers for traditional compute activities and lower transactional costs
*   Experiment more often by carrying out comparative testing with different types of instances, storage types and different configurations
*   Use the technologies that best align with what you’re trying to achieve like data access patterns with databases and other storage approaches.

#### Best Practices

*   Select multiple solutions from the different resource types to improve performance. The four main resource types are:

##### Compute – varies based on application design, usage patterns and configuration settings and available in three different forms:

*   Instances – virtualized servers
*   Containers – resource isolated processes using operating system virtualization
*   Functions – abstracted execution environment from the code

##### Storage – varies based on access methods, patterns of access, throughput, frequency of access, update frequency, availability and durability constraints.
##### Database – varies based on availability, consistency, partition tolerance, latency, durability, scalability and query capability. Available in 3 forms:

*   Managed Relational Databases – Database with tables, rows and columns with relational backbone
*   NoSQL Databases – key, value based pairs
*   Data Warehouses – means of changing the types and number of nodes as performance and capacity needs change

##### Network – Varies based on latency and throughput requirements where physical constraints such as resource placement and location play big factors.

*   Review architecture and performance and understand where bottlenecks are so you can look for tools to alleviate those constraints
*   Set monitors to raise alarms when thresholds are reached and set off automated triggers to work around poorly performing components
*   Trade consistency, availability, durability, space, time, and/or latency to deliver higher performance that aligns with business goals and test the trade-offs to ensure a measurable benefit it obtained.

* * *

### Cost Optimization

#### Design Principles

*   Adopt a consumption model so that you only pay for the computing resources you consume.
*   Measure overall efficiency by monitoring the business output of the system and the costs associated with it
*   Stop spending money on data center operations and allow a cloud service to manage hardware for you
*   Analyze and attribute expenditure to measure return on investment
*   Use managed services to remove the operational burden of maintaining servers for menial tasks

#### Best Practices

*   Cost Effective Resources – Use the most cost effective resources
*   Match Supply and Demand – Actively think about patterns of usage and time to provision new resources so you can add and remove resources as needed
*   Expenditure Awareness - Because you no longer have to think about the cost of manual processes associated with on-campus infrastructure you can now use tags to categorize and track costs of cloud resources and determine what resources or products are no longer generating income
*   Optimize over time – As requirements change be aggressive in decommissioning resources and services no longer needed and be aware of new services and how they could save you money

* * *