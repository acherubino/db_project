# CS3200 Final Project

### Shareable Course Planner

#### Anthony Cherubino

#### NUID: 001483855

#### Section 4 (CRN: 15731)

#### Group 5

#### December 13, 2021

##### Problem Statement:

While Canvas provides an online portal to see one's courses, assignments, and grades, it is limiting that one course can be viewed at a time without a good way of looking at all of a student's courses at once. In addition to this, you can only see your own courses and assignments (understandably), but I think it can be useful to allow this information to be also shared with a group so that one can keep up on what everyone is working on and see when they will be busy.

##### Solution Statement:

To address this issue, I have created this Shareable Course Planner. This database allows users to enter and track their courses and the assignments from those courses in addition to being able to see the other users who are in their class as well as the other assignments that those users have.

##### User:

The typical user of this system would be a Student who is currently enrolled in one or more courses and would like to keep track of their courses/assignments. If there are multiple of these users then they can see what courses they have in common with others as well as see what other assignments another user has in their other courses.

##### Domain Objects:

###### #1 - Users

The users table keeps track of the various students who are currently enrolled in classes. A student can be registered to one or more courses, implemented through a reified one-to-many relationship with the registrations table.

Available actions:

/api/users - **List all users**

/api/users/{id} - **List user by ID**

/api/users/create - **View user creation template**

/api/users/create/{uname}/{pword}/{fname}/{lname}/{email}/{dob} - **Create new user with input data**

/api/users/{id}/{uname}/{pword}/{fname}/{lname}/{email}/{dob} - **Update existing user by ID with input data**

/api/users/{id}/delete - **Delete existing user by ID**

/api/users/{id}/registrations - **View all registrations for a user by ID**

###### #2 - Registrations

The registrations table keeps track of what courses a student is registered for. It is a reified table to allow for many users to be registered for many courses. It has many-to-one relationships with the users and courses tables.

Available actions:

/api/registrations - **List all registrations**

/api/registrations/{id} - **List registration by ID**

/api/registrations/create - **View registration creation template**

/api/registrations/create/{user}/{course} - **Create new registration with input data**

/api/registrations/{id}/{user}/{course} - **Update existing registration by ID with input data**

/api/registrations/{id}/delete - **Delete existing registration by ID**

###### #3 - Courses

The courses table keeps track of all the courses for which a student can be registered. A course can have many users registered for it as well as it can have many assignments. It has one-to-many relationships with the registrations and assignments tables. It makes use of the portable enumeration table course_codes for the department prefix of a course.

Available actions:

/api/courses - **List all courses**

/api/courses/{id} - **List course by ID**

/api/courses/create - **View course creation template**

/api/courses/create/{number}/{name}/{code} - **Create new course with input data**

/api/courses/{id}/{number}/{name}/{code} - **Update existing course by ID with input data**

/api/courses/{id}/delete - **Delete existing course by ID**

/api/courses/{id}/registrations - **View all registrations for a course by ID**

/api/courses/{id}/assignments - **View all assignments for a course by ID**

###### #4 - Course Codes

The course_codes table is a portable enumeration that is used for the department prefix of a course (ie. CS, EECE, CY, etc.). Many courses can have the same enumerated value to correspond to one of these codes.

Available actions:

/api/courseCodes - **List all course codes**

/api/courseCodes/{id} - **List course code by ID**

/api/courseCodes/create - **View course code creation template**

/api/courseCodes/create/{code} - **Create new course code with input data**

/api/courseCodes/{id}/{code} - **Update existing course code by ID with input data**

/api/courseCodes/{id}/delete - **Delete existing course code by ID**

/api/courseCodes/{id}/courses - **View all courses with a course code by ID**

###### #5 - Assignments

The assignments table keeps track of all the assignemtns within the courses which students are registered for. Any given couse can have many assignemnts. It has a many-to-one relationship with the courses table.

/api/assignments - **List all assignments**

/api/assignments/{id} - **List assignment by ID**

/api/assignments/create - **View assignment creation template**

/api/assignments/create/{title}/{dueDate}/{course} - **Create new assignment with input data**

/api/assignments/{id}/{title}/{dueDate}/{course} - **Update existing assignment by ID with input data**

/api/assignments/{id}/delete - **Delete existing assignment by ID**

#### Thanks to Prof. Annunziato and the TAs for a great semester and I hope you all have a nice winter break!
