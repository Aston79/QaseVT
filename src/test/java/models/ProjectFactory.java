package models;

import com.github.javafaker.Faker;

public class ProjectFactory {

        public static Project get() {
                Faker faker = new Faker();
                String name = faker.app().name();
                return Project.builder()
                        .projectName(name)
                        .projectCode(name)
                        .description("This is project test " + name)
                        .build();
        }
}