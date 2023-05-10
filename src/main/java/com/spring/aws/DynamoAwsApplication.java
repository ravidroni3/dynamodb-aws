package com.spring.aws;

import com.spring.aws.entity.Person;
import com.spring.aws.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DynamoAwsApplication {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/savePerson")
    public Person addPerson(@RequestBody Person person) {
        return personRepository.addPerson(person);
    }

    @GetMapping("/getPerson/{personId}")
    public Person findPerson(@PathVariable String personId) {
        return personRepository.findPersonByPerson(personId);
    }

    @PutMapping("/editPerson")
    public String editPerson(@RequestBody Person person) {
        return personRepository.editPerson(person);

    }

    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestBody Person person) {
        return personRepository.deletePerson(person);
    }


    public static void main(String[] args) {
        SpringApplication.run(DynamoAwsApplication.class, args);
    }

}
