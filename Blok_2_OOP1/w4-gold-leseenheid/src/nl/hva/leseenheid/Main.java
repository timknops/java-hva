package nl.hva.leseenheid;

/**
 * Main klasse, bevat testcode.
 *
 * @author Tim Knops
 */

public class Main {

    public static void main(String[] args) {
        Vak nogEenVak = new Vak("Databases", 3, 1);
        System.out.printf("%s, afgerond: %b%n", nogEenVak.toString(), nogEenVak.isAfgerond());
        nogEenVak.setCijfer(5.499999);
        System.out.printf("%s, afgerond: %b%n", nogEenVak.toString(), nogEenVak.isAfgerond());
        nogEenVak.setCijfer(5.5);
        System.out.printf("%s, afgerond: %b%n", nogEenVak.toString(), nogEenVak.isAfgerond());

        ProfessionalSkills nogEenSkill = new ProfessionalSkills("ICT Ethics", 2, 2);
        System.out.printf("%s, afgerond: %b%n", nogEenSkill.toString(), nogEenSkill.isAfgerond());
        nogEenSkill.setGehaald(true);
        System.out.printf("%s, afgerond: %b%n", nogEenSkill.toString(), nogEenSkill.isAfgerond());

        Project nogEenProject = new Project("Agile Development", 12, 1);
        System.out.printf("%s, afgerond: %b%n", nogEenProject.toString(), nogEenProject.isAfgerond());

        nogEenProject.setMethodenEnTechniekenCijfer(5.499999);
        nogEenProject.setProcescijfer(5.5);
        nogEenProject.setProductcijfer(5.5);
        System.out.printf("%s, afgerond: %b%n", nogEenProject.toString(), nogEenProject.isAfgerond());

        nogEenProject.setMethodenEnTechniekenCijfer(5.5);
        nogEenProject.setProcescijfer(5.4999999);
        System.out.printf("%s, afgerond: %b%n", nogEenProject.toString(), nogEenProject.isAfgerond());

        nogEenProject.setProcescijfer(10);
        nogEenProject.setProductcijfer(5.499999);
        System.out.printf("%s, afgerond: %b%n", nogEenProject.toString(), nogEenProject.isAfgerond());

        nogEenProject.setProductcijfer(10);
        System.out.printf("%s, afgerond: %b%n", nogEenProject.toString(), nogEenProject.isAfgerond());

        nogEenProject.setMethodenEnTechniekenCijfer(10);
        System.out.printf("%s, afgerond: %b%n", nogEenProject.toString(), nogEenProject.isAfgerond());
    }
}
