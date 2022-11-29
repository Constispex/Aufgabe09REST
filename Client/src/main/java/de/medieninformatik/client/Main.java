package de.medieninformatik.client;

import de.medieninformatik.common.Student;

public class Main {
    public static void main(String[] args) {
        final String BASE_URI = "http://localhost:8080/rest";

        StudentClient students = new StudentClient(BASE_URI);
        students.get("/studenten/1");
        students.get("/studenten");
        // hinzufügen eines neuen Studenten mit POST
        students.post("/studenten", new Student(4, "Neville"));
        // Fehler: 5 existiert nicht, daher kein PUT möglich
        students.put("/studenten/5", new Student(5, "Draco"));
        // Überscreiben eines bestehenden Studenten
        students.put("/studenten/2", new Student(2, "Ronald"));
        students.get("/studenten");
        students.delete("/studenten/4");
        students.get("/studenten");
    }
}