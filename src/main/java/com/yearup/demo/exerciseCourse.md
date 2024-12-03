### Environment settings

1. Update the application.properties (in resources)
2. Make sure that the username and password match yours
3. jdbc:mysql://localhost:3306/demo <<<< demo is the name of my database
4. Replace with the name of your database, or add a schema demo in workbench

---

### Creating the model 

1. Create a class Course in models package
2. Give it an id, name, description and avgGrade
3. Annotate it like the examples in models (annotation are with the @...)

---

### Creating the repository

1. Create an interface CourseRepository in repositories package
2. Make it extend JpaRepository<Course, Long> (if your id in model is of type long)

---

### Creating the service

1. Create a service CourseService in services package
2. Have a look at the ProductService for how to implement it.
3. Add methods for: getting all the courses, getting a course by id, updating a course, adding a course and deleting a course

---

### Creating the controller

1. Create a controller CourseController in controllers package
2. Have a look at the ProductController for how to implement it
3. Add endpoints for: getting all the courses, getting a course by id, updating a course, adding a course and deleting a course

---

### Testing the application 

Test it in postman, and verify all the endpoints work using mysql workbench