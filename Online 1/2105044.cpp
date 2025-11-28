#include<iostream>
#include<cstring>
using namespace std;

class Book{
    string Title;
    string Author;
    int Availability;//1 means available,2 means  not
public :
    Book()
    {

    }
    void setbook(const string Title,const string Author)
    {
        strcpy(this->Title,Title);
        strcpy(this->Author,Author);
        Availability=1;
    }
    string getTitle()
    {
        return Title;
    }
    string getAuthor()
    {
        return Author;
    }
    int getAvailability()
    {
        return Availability;
    }
    void displayBook()
    {
        cout<<"Title: "<<this->Title<<endl;
        cout<<"Author: "<<this->Author<<endl;
        if(Availability==1)
            cout<<"Availability: Available"<<endl;
        else if(Availability==2)
           cout<<"Availability: Not Available"<<endl;
    }
    ~Book()
    {

    }
};

class LibraryMember{
    string name;
    string cardNumber;
public:
    LibraryMember()
    {

    }
    void setDetails(string name,string cardNumber)
    {
        strcpy(this->name,name);
        strcpy(this->cardNumber,cardNumber);
    }
    string getname()
    {
        return name;
    }
    string getcardNumber()
    {
        return cardNumber;
    }
    void Displaylibmem()
    {
        cout<<"Name: "<<name<<endl;
        cout<<"Library Card Number: "<<cardNumber<<endl;
    }
    ~LibraryMember()
    {

    }
};

class Library
{
    Books *book;
    book_count;
    LibraryMember *mem;
    mem_count;
public :
    Library()
    {
        book= new Books[100];
        book_count=0;
        mem = new LibraryMember[100];
        mem_count=0;
    }
    void addBook(Book &b)
    {
        book[book_count++]=b;
    }
    void registerMember(LibraryMember &lm)
    {
        mem[mem_count++]=lm;
    }
    void displayAllBooks()
    {
        for(int i=0;i<book_count;i++)
            book[i].displayBook();
    }
     void displayAllMembers()
    {
        for(int i=0;i<mem_count;i++)
            mem[i].Displaylibmem();
    }

    void borrowBook(string x,string y)
    {
        for(int i=0;i<book_count;i++)
        {
            if(!strcmp(book[i].getTitle,x))
                book[i].availability=2;
        }
         for(int i=0;i<mem_count;i++)
        {
            if(!strcmp(mem[i].getcardNumber,y))
              cout<<"Book "<<x<<" has been borrowed by "endl;
              mem[i].Displaylibmem;
              return;
        }
    }

    void returnBook(string x,string y)
    {
        for(int i=0;i<book_count;i++)
        {
            if(!strcmp(book[i].getTitle,x))
                book[i].availability=1;
        }
         for(int i=0;i<mem_count;i++)
        {
            if(!strcmp(mem[i].getcardNumber,y))
              cout<<"Book "<<x<<" has been returned by "endl;
              mem[i].Displaylibmem;
              return;
        }
    }


    void removeBook(string x)
    {
        if(book_count==0) return;
        int temp;
        for(int i=0;i<book_count;i++)
        {
            if(!strcmp(book[i].getTitle,x))
                temp=i;
                break;
        }
        if(temp==book_count-1)
        {
            book_count--;
        }
        else
             for(int i=temp;i<book_count-1;i++)
        {
             book[i]=book[i+1];
        }


    }
    void removeMember(string x)
    {
        if(mem_count==0) return;
        int temp;
        for(int i=0;i<mem_count;i++)
        {
            if(!strcmp(mem[i].getcardNumber,x))
                temp=i;
                break;
        }
        if(temp==mem_count-1)
        {
            mem_count--;
        }
        else
             for(int i=temp;i<mem_count-1;i++)
        {
             mem[i]=mem[i+1];
        }
    }
    ~Library()
    {
        delete [] book;
        delete [] mem;
    }

};

int main() {
Library library;
// Adding books
library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
library.addBook("To Kill a Mockingbird", "Harper Lee");
library.addBook("Pride and Prejudice", "Jane Austen");
// Displaying all books
library.displayAllBooks();
// Registering members
library.registerMember("John Doe", 1234);
library.registerMember("Jane Smith", 5678);
// Displaying all members
library.displayAllMembers();
// Borrowing books
library.borrowBook("The Great Gatsby", 1234);
library.borrowBook("To Kill a Mockingbird", 5678);
// Displaying all books (after borrowing)
library.displayAllBooks();
// Returning a book
library.returnBook("The Great Gatsby", 1234);
// Displaying all books (after returning)
library.displayAllBooks();
// Removing a book
library.removeBook("Pride and Prejudice");
// Displaying all books (after removal)
library.displayAllBooks();
// Removing a member
library.removeMember(5678);
// Displaying all members (after removal)
library.displayAllMembers();
return 0;
}

