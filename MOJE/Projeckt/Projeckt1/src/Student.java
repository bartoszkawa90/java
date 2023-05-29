public class Student extends Person {

    public int studentID;
    public Student(){
        super();
        studentID = 0;
    }
    public Student(int age, String name,String surname, int studentID){
        super(age,surname,name);
        this.studentID = studentID;
    }

    public static void main(String[] args) {

        Student student = new Student(20,"Kowalski","Norman",100);
        System.out.println("Name " + student.name);
        System.out.println("Surname " + student.surname);
        System.out.println("Age " + student.age);
        System.out.println("ID " + student.studentID);

        System.out.println(student.rasa);


    }

}
