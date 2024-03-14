package baitap.ra.business.implement;

import baitap.ra.business.config.InputMethods;
import baitap.ra.business.design.CRUD;
import baitap.ra.business.entity.Student;

import java.util.Scanner;

public class StudentImplement implements CRUD {
    private static Student[] students = new Student[100];
    private int size = 0;
    @Override
    public void create() {
        if (size == 100){
            System.err.println("mảng đầy");
        }else {
            // logic thêm mới
            // ta 1 đối tượng student
            Student newStudent = new Student();
            newStudent.inputData();
            // thêm vào mang
            students[size] = newStudent;
            size++; // tăng số lương
        }
    }

    @Override
    public void display() {
        if (size == 0){
            System.err.println("mảng ko co ptu");
        }else {
            for (int i = 0; i < size; i++) {
                System.out.println(students[i]);
            }
        }
    }

    @Override
    public void edit() {
        System.out.println("Nhập mã muốn sửa");
        byte idEdit = InputMethods.getByte();
        for (int i = 0; i < size; i++) {
            if (students[i].getStudentId()==idEdit){
                students[i].inputData();
            }
        }
    }

    @Override
    public void delete() {
        System.out.println("Nhập mã muốn xóa");
        byte idDelete = InputMethods.getByte();
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (students[i].getStudentId()==idDelete){
                index=i;
            }
        }
        if (index!=-1){
            for (int i = index; i < size-1; i++) {
                students[i]=students[i+1];
            }
            --size;
            System.out.println("Đã xóa sản phẩm có mã: :" +idDelete);
        }else {
            System.out.println("Không tìm thấy sản phẩm có mã:");
        }

    }

}
