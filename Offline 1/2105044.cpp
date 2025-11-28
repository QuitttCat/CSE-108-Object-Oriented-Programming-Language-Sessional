#include<iostream>
#include<cstring>
#include<cstdlib>
using namespace std;

class Student{
    //the class Student that has three private member variables,
    //namely roll (integer), name (string), and cgpa (float).
    int roll;
    char *name;
    float cgpa;

public:
    Student()
    {
        //default constructor
    }

    Student(const char *name)
    {
        this->name=(char *)malloc(sizeof(char)*strlen(name)); //dynamically memory allocation
        strcpy(this->name,name);
    }

    Student(int roll)
    {
       this->roll=roll;
    }

    Student(float cgpa)
    {
        this->cgpa=cgpa;
    }

    Student(int roll,const char *name,float cgpa)
    {

        this->roll=roll;
        this->name=(char *)malloc(sizeof(char)*strlen(name));
        strcpy(this->name,name);
        this->cgpa=cgpa;
    }

    void setname(const char *name)
    {
        this->name=(char *)malloc(sizeof(char)*strlen(name));
        strcpy(this->name,name);
    }

    //setters

    void setroll(int roll)
    {
        this->roll=roll;
    }

    void setcg(float cgpa)
    {
        this->cgpa=cgpa;
    }

    //getters

    char *getname()
    {
        return name;
    }
    int getroll()
    {
        return roll;
    }
    float getcg()
    {
        return cgpa;
    }

    //destructor to make memory free and set roll to zero
    ~Student()
    {
        roll=0;
        free(name);//freeing the memory which was allocated dynamically
    }
};



int main()
{
    Student s1;
    Student s2("Karim");
    Student s3(3);
    Student s4(4, "Rahim", 3.52);
    Student s5(5, "Sakib", 3.92);
    s1.setname("Papon");
    s1.setroll(1);
    s1.setcg(4.00);
    s2.setroll(2);
    s2.setcg(3.8);
    s3.setname("Abdul");
    s3.setcg(3.96);
    float avg=(s1.getcg()+s2.getcg()+s3.getcg()+s4.getcg()+s5.getcg())/5;
    cout<<"Student #1"<<endl;
    cout<<"Roll : "<<s1.getroll()<<endl;
    cout<<"Name : "<<s1.getname()<<endl;
    cout<<"CGPA : "<<s1.getcg()<<endl<<endl;

    cout<<"Student #2"<<endl;
    cout<<"Roll : "<<s2.getroll()<<endl;
    cout<<"Name : "<<s2.getname()<<endl;
    cout<<"CGPA : "<<s2.getcg()<<endl<<endl;

    cout<<"Student #3"<<endl;
    cout<<"Roll : "<<s3.getroll()<<endl;
    cout<<"Name : "<<s3.getname()<<endl;
    cout<<"CGPA : "<<s3.getcg()<<endl<<endl;

    cout<<"Student #4"<<endl;
    cout<<"Roll : "<<s4.getroll()<<endl;
    cout<<"Name : "<<s4.getname()<<endl;
    cout<<"CGPA : "<<s4.getcg()<<endl<<endl;

    cout<<"Student #5"<<endl;
    cout<<"Roll : "<<s5.getroll()<<endl;
    cout<<"Name : "<<s5.getname()<<endl;
    cout<<"CGPA : "<<s5.getcg()<<endl<<endl;


    cout<<"Average of CGPA : "<<avg<<endl;



}



