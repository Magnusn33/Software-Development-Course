/*
package com.example.project2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BachelorProgramTest {

    // Test if two instances with same name
    @Test
    void testDobbelName() {
        BachelorProgram program = new BachelorProgram();

        program.addCourse(new BasicCourse(5, "EssentialComputing"));
        program.addCourse(new ElectiveCourse(10, "LinearAlgebra", "Basis"));
        program.addCourse(new BachelorProject("TechnoStress"));
        program.addCourse(new BasisProject("RPA1"));
        program.addCourse(new BasisProject("RPA2"));
        program.addCourse(new BasisProject("RPA3"));
        program.addCourse(new SubjectProject("Gamification", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Digital Stress", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Digital Stress", "Design"));
        program.addCourse(new BasicCourse(10, "EssentialComputing2"));
        program.addCourse(new BasicCourse(10, "EssentialComputing3"));
        program.addCourse(new BasicCourse(10, "EssentialComputing4"));
        program.addCourse(new BasicCourse(10, "EssentialComputing5"));
        program.addCourse(new BasicCourse(10, "EssentialComputing6"));
        program.addCourse(new BasicCourse(10, "EssentialComputing7"));
        program.addCourse(new BasicCourse(10, "EssentialComputing8"));
        program.addCourse(new BasicCourse(10, "EssentialComputing9"));

        Assertions.assertFalse(BachelorProgram.valid(program.courses, BachelorProgram.CountInstance(program.courses)));
    }

    // test if there is missing a BA project
    @Test
    void testMissingBachelorProject() {
        BachelorProgram program = new BachelorProgram();

        program.addCourse(new BasicCourse(5, "EssentialComputing"));
        program.addCourse(new ElectiveCourse(10, "LinearAlgebra", "Basis"));
        program.addCourse(new BasisProject("TechnoStress"));
        program.addCourse(new BasisProject("RPA1"));
        program.addCourse(new BasisProject("RPA2"));
        program.addCourse(new BasisProject("RPA3"));
        program.addCourse(new SubjectProject("Gamification", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Digital Stress", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Stress", "Design"));
        program.addCourse(new BasicCourse(10, "EssentialComputing2"));
        program.addCourse(new BasicCourse(10, "EssentialComputing3"));
        program.addCourse(new BasicCourse(10, "EssentialComputing4"));
        program.addCourse(new BasicCourse(10, "EssentialComputing5"));
        program.addCourse(new BasicCourse(10, "EssentialComputing6"));
        program.addCourse(new BasicCourse(10, "EssentialComputing7"));
        program.addCourse(new BasicCourse(10, "EssentialComputing8"));
        program.addCourse(new BasicCourse(10, "EssentialComputing9"));

        Assertions.assertFalse(BachelorProgram.valid(program.courses, BachelorProgram.CountInstance(program.courses)));
    }

    // test if there are enough basis projects
    @Test
    void testMissingBasisProject() {
        BachelorProgram program = new BachelorProgram();

        program.addCourse(new BasicCourse(5, "EssentialComputing"));
        program.addCourse(new ElectiveCourse(10, "LinearAlgebra", "Basis"));
        program.addCourse(new BachelorProject("TechnoStress"));
        program.addCourse(new ElectiveCourse(15,"RPA1", "Basis"));
        program.addCourse(new BasisProject("RPA2"));
        program.addCourse(new BasisProject("RPA3"));
        program.addCourse(new SubjectProject("Gamification", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Digital Stress", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Digital Stress", "Design"));
        program.addCourse(new BasicCourse(10, "EssentialComputing2"));
        program.addCourse(new BasicCourse(10, "EssentialComputing3"));
        program.addCourse(new BasicCourse(10, "EssentialComputing4"));
        program.addCourse(new BasicCourse(10, "EssentialComputing5"));
        program.addCourse(new BasicCourse(10, "EssentialComputing6"));
        program.addCourse(new BasicCourse(10, "EssentialComputing7"));
        program.addCourse(new BasicCourse(10, "EssentialComputing8"));
        program.addCourse(new BasicCourse(10, "EssentialComputing9"));

        Assertions.assertFalse(BachelorProgram.valid(program.courses, BachelorProgram.CountInstance(program.courses)));
    }

    // test if there are too few ects
    @Test
    void testToFewECTS() {
        BachelorProgram program = new BachelorProgram();

        program.addCourse(new BasicCourse(5, "EssentialComputing"));
        program.addCourse(new ElectiveCourse(10, "LinearAlgebra", "Basis"));
        program.addCourse(new BachelorProject("TechnoStress"));
        program.addCourse(new BasisProject("RPA1"));
        program.addCourse(new BasisProject("RPA2"));
        program.addCourse(new BasisProject("RPA3"));
        program.addCourse(new SubjectProject("Gamification", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Digital Stress", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Stress", "Design"));
        program.addCourse(new BasicCourse(5, "EssentialComputing2"));
        program.addCourse(new BasicCourse(10, "EssentialComputing3"));
        program.addCourse(new BasicCourse(10, "EssentialComputing4"));
        program.addCourse(new BasicCourse(10, "EssentialComputing5"));
        program.addCourse(new BasicCourse(10, "EssentialComputing6"));
        program.addCourse(new BasicCourse(10, "EssentialComputing7"));
        program.addCourse(new BasicCourse(10, "EssentialComputing8"));
        program.addCourse(new BasicCourse(10, "EssentialComputing9"));

        Assertions.assertFalse(BachelorProgram.valid(program.courses, BachelorProgram.CountInstance(program.courses)));
    }

    // test if there are too many ects
    @Test
    void testToManyECTS() {
        BachelorProgram program = new BachelorProgram();

        program.addCourse(new BasicCourse(5, "EssentialComputing"));
        program.addCourse(new ElectiveCourse(10, "LinearAlgebra", "Basis"));
        program.addCourse(new BachelorProject("TechnoStress"));
        program.addCourse(new BasisProject("RPA1"));
        program.addCourse(new BasisProject("RPA2"));
        program.addCourse(new BasisProject("RPA3"));
        program.addCourse(new SubjectProject("Gamification", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Digital Stress", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Stress", "Design"));
        program.addCourse(new BasicCourse(15, "EssentialComputing2"));
        program.addCourse(new BasicCourse(10, "EssentialComputing3"));
        program.addCourse(new BasicCourse(10, "EssentialComputing4"));
        program.addCourse(new BasicCourse(10, "EssentialComputing5"));
        program.addCourse(new BasicCourse(10, "EssentialComputing6"));
        program.addCourse(new BasicCourse(10, "EssentialComputing7"));
        program.addCourse(new BasicCourse(10, "EssentialComputing8"));
        program.addCourse(new BasicCourse(10, "EssentialComputing9"));

        Assertions.assertFalse(BachelorProgram.valid(program.courses, BachelorProgram.CountInstance(program.courses)));
    }

}

 */