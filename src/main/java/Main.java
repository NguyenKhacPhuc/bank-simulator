import controller.AdminManagement;
import controller.GradeReportCreationTask;
import controller.ScheduleCreationTask;
import controller.TeacherManagement;
import data.Admin;
import data.Schedule;
import data.Teacher;
import mysqldatabase.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = new DatabaseConnection().getConnection();
        Schedule schedule = new Schedule();
        TeacherManagement teacherManagement = new TeacherManagement();


        Admin admin = new Admin(teacherManagement.getAllTeachers(connection), null, null, null);
        for(int i = 0; i < admin.getTeacherList().size(); i++){
            System.out.println(admin.getTeacherList().get(i).toString());
        }

        AdminManagement adminManagement = new AdminManagement();
//        adminManagement.addSchedule(connection, schedule);
        Teacher teacher = new Teacher();
//        adminManagement.addTeacher(connection, teacher);
//        adminManagement.deleteTeacher(connection, teacher);


        try {
            ScheduleCreationTask scheduleCreationTask = new ScheduleCreationTask(connection, schedule, adminManagement);
            scheduleCreationTask.start();

            GradeReportCreationTask gradeReportCreationTask = new GradeReportCreationTask();
            gradeReportCreationTask.start();

            scheduleCreationTask.join();
            gradeReportCreationTask.join();
            System.out.println("All Task completed");
        } catch (Exception e) {
            System.out.println("Failed to complete task");
        }

    }
}