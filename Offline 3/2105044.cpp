#include<iostream>
#include<cmath>
using namespace std;

class Point2D
{
    double x,y;
public:
    Point2D()
    {
        x = 0;
        y = 0;
    }
    Point2D(double x, double y);
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
    void print();
    ~Point2D();
    Point2D operator+(const Point2D &p);
    Point2D operator*(const double &n);
    bool operator==(const Point2D &p);
    bool operator!=(const Point2D &p);
};

Point2D::Point2D(double argx,double argy)
{
    x = argx;
    y = argy;
}

void Point2D::setX(double argx)
{
    x=argx;
}

void Point2D::setY(double argy)
{
    y = argy;
}

double Point2D::getX()
{
    return x;
}

double Point2D::getY()
{
    return y;
}

void Point2D::print()
{
    cout << "(" << x << "," << y << ")";
}

Point2D::~Point2D()
{
    x = 0;
    y = 0;
}

Point2D Point2D::operator+(const Point2D &p)
{
    Point2D temp(x+p.x,y+p.y);
    return temp;
}
Point2D Point2D::operator*(const double &n)
{
    Point2D temp(x*n,y*n);
    return temp;
}
bool Point2D::operator==(const Point2D &p)
{
    return (x==p.x and y==p.y);
}
bool Point2D::operator!=(const Point2D &p)
{
    return !(x==p.x and y==p.y);
}



class Circle
{
    Point2D center;
    double radius;
public:
    Circle();
    Circle(Point2D c, double r);
    void setCenter(Point2D c);
    void setRadius(double r);
    Point2D getCenter();
    double getRadius();
    void print();
    ~Circle();
    Circle operator+(const Point2D &p);
    Circle operator*(const double &n);
    Circle operator+(Circle cr);
    Circle operator-(Circle cr);
    bool operator==(const Circle &cr);
    bool operator>(const Circle &cr);
    bool operator>=(const Circle &cr);
    bool operator<(const Circle &cr);
    bool operator<=(const Circle &cr);
    Circle operator++();
    Circle operator++(int notused);
};


Circle:: Circle()
{
    center.setX(0);
    center.setY(0);
    radius=0;
}

Circle::Circle(Point2D c, double r)
{
    center.setX(c.getX());
    center.setY(c.getY());
    radius=r;
}

void Circle::setCenter(Point2D c)
{
    center.setX(c.getX());
    center.setY(c.getY());
}

void Circle::setRadius(double r)
{
    radius=r;
}
Point2D Circle::getCenter()
{
    return center;
}
double Circle::getRadius()
{
    return radius;
}

void Circle::print()
{
    cout << "[Center: ";
    center.print();
    cout << " Radius: " << radius;
    cout<<"]";
}

Circle::~Circle()
{
    center.setX(0);
    center.setY(0);
    radius=0;
}

Circle Circle::operator+(const Point2D &p)
{
    Circle temp(center+p,radius);
    return temp;
}

Circle Circle::operator*(const double &n)
{
    Circle temp(center*n,radius*n);
    return temp;
}

Circle Circle::operator+(Circle cr)
{
    double a=(radius/(radius+cr.radius));
    Circle temp(center*a+cr.center*(1-a),radius+cr.radius);
    return temp;
}

Circle Circle::operator-(Circle cr)
{
    double a=(radius/(radius+cr.radius));
    Circle temp(center*a+cr.center*(1-a),abs(radius-cr.radius));
    return temp;
}

bool Circle::operator==(const Circle &cr)
{
    return radius==cr.radius;
}

bool Circle::operator>(const Circle &cr)
{
    return radius>cr.radius;
}

bool Circle::operator>=(const Circle &cr)
{
    return radius>=cr.radius;
}

bool Circle::operator<(const Circle &cr)
{
    return radius<cr.radius;
}

bool Circle::operator<=(const Circle &cr)
{
    return radius<=cr.radius;
}

Circle Circle::operator++()
{
    radius++;
    cout<<"Pre Increment"<<endl;
    return *this;
}
Circle Circle::operator++(int notused)
{
    radius++;
    cout<<"Post Increment"<<endl;
    return *this;
}

class Rectangle
{
    Point2D topRightPoint,bottomLeftPoint;
public:
    Rectangle();
    Rectangle(Point2D oneCorner,Point2D anotherCorner);
    void setTopRightPoint(Point2D oneCorner);
    void setbottomLeftPoint(Point2D anotherCorner);
    Point2D getTopRightPoint();
    Point2D getBottomLeftPoint();
    void print();
    ~Rectangle();
    Rectangle operator+(const Point2D &p);
    Rectangle operator*(const double &n);
};

Rectangle::Rectangle()
{
    topRightPoint.setX(0);
    topRightPoint.setY(0);
    bottomLeftPoint.setX(0);
    bottomLeftPoint.setY(0);
}

Rectangle::Rectangle(Point2D oneCorner,Point2D anotherCorner)
{
    topRightPoint=oneCorner;
    bottomLeftPoint=anotherCorner;
}

void Rectangle::setTopRightPoint(Point2D oneCorner)
{
    topRightPoint=oneCorner;
}
void Rectangle::setbottomLeftPoint(Point2D anotherCorner)
{
    bottomLeftPoint=anotherCorner;
}
Point2D Rectangle::getTopRightPoint()
{
    return topRightPoint;
}
Point2D Rectangle::getBottomLeftPoint()
{
    return bottomLeftPoint;
}

void Rectangle::print()
{
    cout<<"[Top Right Point: ";
    topRightPoint.print();
    cout<<"  Bottom left Point: ";
    bottomLeftPoint.print();
    cout<<"]";
}
Rectangle::~Rectangle()
{
    topRightPoint.setX(0);
    topRightPoint.setY(0);
    bottomLeftPoint.setX(0);
    bottomLeftPoint.setY(0);
}

Rectangle Rectangle::operator+(const Point2D &p)
{
    Rectangle temp(topRightPoint+p,bottomLeftPoint+p);
    return temp;
}

Rectangle Rectangle::operator*(const double &n)
{
    Rectangle temp(topRightPoint*n,bottomLeftPoint*n);
    return temp;
}

int main()
{
    Point2D p1(5,10),p2(15,10),p3;
    Circle c1(p1,10),c2,c3;
    Rectangle r1(p1,p2),r2;

    //operator overloading test for point class
    cout<<"operator overloading test for point class : \n"<<endl;

    cout<<"p1 = ";
    p1.print();
    cout<<"\n";

    cout<<"p2 = ";
    p2.print();
    cout<<"\n";

    cout<<"p1 + p2 = ";
    (p1+p2).print();
    cout<<"\n";

    cout<<"(p1 + p2)*5 = ";
    ((p1+p2)*5).print();
    cout<<"\n";

    p3.setX(5);
    p3.setY(10);
    cout<<"p3 = ";
    p3.print();
    cout<<"\n";


    if(p1==p2) cout<<"p1 and p2 is the same point."<<endl;
    else cout<<"p1 and p2 is not the same point"<<endl;

    if(p1!=p3) cout<<"p1 and p3 is not the same point."<<endl;
    else cout<<"p1 and p3 is the same point\n\n"<<endl;

    //operator overloading test for circle class
    cout<<"operator overloading test for circle  class : \n"<<endl;
    cout<<"c1 : "<<endl;
    c1.print();
    cout<<"\n";

    cout<<"c1+p1 : "<<endl;
    (c1+p1).print();
    cout<<"\n";

    cout<<"c1*5 : "<<endl;
    (c1*5).print();
    cout<<"\n";

    c2=++c1;
    cout<<"c2 : "<<endl;
    c2.print();
    cout<<"\n";

    cout<<"c1 : "<<endl;
    c1.print();
    cout<<"\n";

    c2=c1++;
    cout<<"c2 : "<<endl;
    c2.print();
    cout<<"\n";

    cout<<"c1 : "<<endl;
    c1.print();
    cout<<"\n";

    c2.setCenter(p3);
    c2.setRadius(5);
    cout<<"c2 : "<<endl;
    c2.print();
    cout<<"\n";

    c1.setCenter(p2);
    c1.setRadius(6);
    cout<<"c1 : "<<endl;
    c1.print();
    cout<<"\n";

    cout<<"c1 + c2 : "<<endl;
    (c1+c2).print();
    cout<<"\n";

    cout<<"c1 - c2 : "<<endl;
    (c1-c2).print();
    cout<<"\n";

    c3.setCenter(p1);
    c3.setRadius(5);
    cout<<"c3 : "<<endl;
    c3.print();
    cout<<"\n";

    if(c2==c3) cout<<"c2 and c3 has the same area"<<endl;
    else cout<<"c2 and c3 dose not have the same area"<<endl;

    if(c1>c3) cout<<"area of c1 is larger than c3"<<endl;
    if(c3<c1) cout<<"area of c3 is smaller than c1"<<endl;
    if(c2>=c3) cout<<"area of c2 is larger than or equal to c3"<<endl;
    if(c3<=c1) cout<<"area of c3 is smaller than or equal to c1\n\n"<<endl;






    //operator overloading test for rectangle class
    cout<<"operator overloading test for rectangle class : \n"<<endl;
    cout<<"r1 : "<<endl;
    r1.print();
    cout<<"\n";

    cout<<"r1 + p1 : "<<endl;
    (r1+p1).print();
    cout<<"\n";

    cout<<"r1 * 5 : "<<endl;
    (r1*5).print();
    cout<<"\n";

    return 0;
}
