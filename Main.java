import java.util.*;


public class Main {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in) ;
       Priorities priorities = new Priorities() ;


       int totalEvents = Integer.parseInt(scanner.nextLine());
       List <String> events = new ArrayList<>();

       while (totalEvents--!= 0 ){
           String event = scanner.nextLine();
           events.add(event) ;
       }

       List <Student> students= priorities.getStudents(events) ;
       if (students.isEmpty()) {
           System.out.println("Empty");
       }
       else {
           for (Student st  :students) {
               System.out.println(st.getName());
           }
       }

    }
}


class Priorities {
    public List<Student> getStudents(List <String>events){
        PriorityQueue<Student> p = new PriorityQueue<>(new MyComparator());


        for (int i = 0 ; i<events.size(); i++) {
            String str[] = events.get(i).split("\\s");
            if (str [0].equalsIgnoreCase("ENTER")){
                p.add(new Student(str[1],Double.parseDouble(str[2]),Integer.parseInt(str[3])));
            }
            if (str[0].equalsIgnoreCase("SERVED")){
                p.poll();
            }
        }
        List<Student> studentlist= new ArrayList<>();
        for (Student s : p) {
            studentlist.add(s);
        }
        studentlist.sort(new MyComparator());

        return studentlist;

    }

}
class Student {

    private int id;
    private String name;
    private double cgpa;


    public Student (String name,double cgpa,int id){
        this.id=id;
        this.name=name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }


}
class MyComparator implements Comparator<Student> {

    public int compare(Student student1, Student student2) {
        if (student2.getCgpa()>student2.getCgpa()) {
            return (1);
        }
        else if (student2.getCgpa()<student1.getCgpa()) {
            return (-1);
        }
        else {
            int secondCompare = student1.getName().compareTo(student2.getName());
            if (secondCompare !=0) return secondCompare;
            int thirdcompare = student1.getId() - student2.getId();
            return thirdcompare;
        }
    }
}

