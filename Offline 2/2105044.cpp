#include <iostream>
#include <cmath>
#include <sstream>
#include<cstdlib>
#include <fstream>
#include<time.h>

using namespace std;

#define GRIDSIZE 4
#define UP      0
#define DOWN    2
#define LEFT    3
#define RIGHT   1
#define MAX_SHOTS 3

/*
string to_string(int x)
{
    std::string out_string;
    std::stringstream ss;
    ss << x;
    return ss.str();
}*/


class Position
{

    int x, y;

public:

    Position (int x, int y)
    {
        this->x = x;
        this->y = y;
    }

    Position() {}

    // Modify the following four so that the resulting position does not leave the grid
    void moveRight()
    {
        if(x<GRIDSIZE-1) x++;
        else cout<<"Player is at the edge!"<<endl;
    }

    void moveLeft()
    {
        if(x>0) x--;
        else cout<<"Player is at the edge!"<<endl;
    }

    void moveUp()
    {
        if(y<GRIDSIZE-1) y++;
        else cout<<"Player is at the edge!"<<endl;
    }

    void moveDown()
    {
        if(y>0) y--;
        else cout<<"Player is at the edge!"<<endl;
    }

    bool isAdjacent(Position p)
    {
        if(((this->x-p.getX()==1) or(this->x-p.getX()==-1)) and (this->y==p.getY())) return true;
        else if(((this->y-p.getY()==1) or(this->y-p.getY()==-1)) and (this->x==p.getX())) return true;
        else return false;
    }

    bool isSamePoint(Position p)
    {
        if((this->x==p.getX()) and (this->y==p.getY())) return true;
        return false;
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

};


class Wumpus
{

    bool killed;
    Position p;

public:

    Wumpus()
    {
        killed=false;
        srand(time(0));
        this->p=Position(rand()%GRIDSIZE,rand()%GRIDSIZE);
    }


    Wumpus(int x, int y)
    {
        p = Position(x, y);
        killed = false;
    }

    void kill()
    {
        killed = true;
        cout<<"Wumpus is dead!"<<endl;
    }

    Position getPosition()
    {
        return p;
    }
    bool getKilled()
    {
        return killed;
    }

};


class Player
{

    int direction;
    int total_shots;
    bool killed;
    Position p;

public:

    Player()
    {
        this->p=Position(0,0);
        this->direction=UP;
        this->total_shots=MAX_SHOTS;
        this->killed=false;
    }

    void turnLeft()
    {
        if(this->direction==UP) this->direction=LEFT;
        else if(this->direction==LEFT) this->direction=DOWN;
        else if(this->direction==DOWN) this->direction=RIGHT;
        else if(this->direction==RIGHT) this->direction=UP;
    }

    void turnRight()
    {
        if(this->direction==UP) this->direction=RIGHT;
        else if(this->direction==RIGHT) this->direction=DOWN;
        else if(this->direction==DOWN) this->direction=LEFT;
        else if(this->direction==LEFT) this->direction=UP;
    }

    void moveForward()
    {
        if(this->direction==UP) this->p.moveUp();
        else if(this->direction==LEFT) this->p.moveLeft();
        else if(this->direction==DOWN) this->p.moveDown();
        else if(this->direction==RIGHT) this->p.moveRight();
    }

    bool isAdjacent(Position pos)
    {
        return p.isAdjacent(pos);
    }

    bool isSamePoint(Position pos)
    {
        return p.isSamePoint(pos);
    }
    int get_total_shots()
    {
        return total_shots;
    }
    void set_total_shots(int x)
    {
        this->total_shots=x;
    }

    void kill()
    {
        killed = true;

    }
    Position getPosition()
    {
        return p;
    }
    int getDirection()
    {
        return direction;
    }

    void getPositionInfo()
    {
        cout<<"Player is now at "<<p.getX()<<" , "<<p.getY()<<endl;
    }

    void getTotalShotinfo()
    {
        cout<<"Player has total shots = "<<total_shots<<endl;
    }

    void getDirectionInfo()
    {
        string s;
        if (direction == UP) s = "up";
        if (direction == DOWN) s = "down";
        if (direction == LEFT) s = "left";
        if (direction == RIGHT) s = "right";
        cout<<"Player is moving at direction : "<<s<<endl;
    }

};


class WumpusWorld
{

private:

    Player player;
    Wumpus wumpus;
    Position gold_position;
    Position pit_position;
    bool ended;

public:

    WumpusWorld()
    {

        this->gold_position=Position(rand()%GRIDSIZE,rand()%GRIDSIZE);
        this->pit_position=Position(rand()%GRIDSIZE,rand()%GRIDSIZE);
    }

    WumpusWorld(int wumpus_x, int wumpus_y)
    {

        this->wumpus=Wumpus(wumpus_x,wumpus_y);
        this->gold_position=Position(rand()%GRIDSIZE,rand()%GRIDSIZE);
        this->pit_position=Position(rand()%GRIDSIZE,rand()%GRIDSIZE);
    }

    WumpusWorld(int wumpus_x, int wumpus_y, int gold_x, int gold_y)
    {

        this->wumpus=Wumpus(wumpus_x,wumpus_y);
        this->gold_position=Position(gold_x,gold_y);
        this->pit_position=Position(rand()%GRIDSIZE,rand()%GRIDSIZE);
    }

    WumpusWorld(int wumpus_x, int wumpus_y, int gold_x, int gold_y, int pit_x, int pit_y)
    {

        this->wumpus=Wumpus(wumpus_x,wumpus_y);
        this->gold_position=Position(gold_x,gold_y);
        this->pit_position=Position(pit_x,pit_y);
    }

    void moveForward()
    {
        player.moveForward();
        return showGameState();
    }

    void turnLeft()
    {
        player.turnLeft();
        return showGameState();
    }

    void turnRight()
    {
        player.turnRight();
        return showGameState();
    }

    void shoot()
    {
        if(player.get_total_shots())
        {
            int x=player.get_total_shots();
            player.set_total_shots(--x);
            Player shoting=player;



            while(1)
            {
                Position pos_cur=shoting.getPosition();
                if(shoting.getDirection()==UP and pos_cur.getY()==3  or shoting.getDirection()==DOWN and pos_cur.getY()==0 or shoting.getDirection()==RIGHT and pos_cur.getX()==3 or shoting.getDirection()==LEFT and pos_cur.getX()==0 )
                {
                    if(shoting.isSamePoint(wumpus.getPosition()))
                    {
                        wumpus.kill();
                    }

                    break;
                }
                else
                {
                    if(shoting.isSamePoint(wumpus.getPosition()))
                    {
                        wumpus.kill();
                        break;
                    }
                    else shoting.moveForward();
                }
            }

        }

        return showGameState();
    }

    void showGameState()
    {
        player.getPositionInfo();
        player.getDirectionInfo();
        player.getTotalShotinfo();


        if (player.isAdjacent(wumpus.getPosition()) and !wumpus.getKilled())
        {
            cout << "stench!" << endl;
        }
        if (player.isAdjacent(getPitPos()))
        {
            cout << "breeze!" << endl;
        }


        if (player.isSamePoint(wumpus.getPosition()) and !wumpus.getKilled())
        {
            cout << "Player is killed by Wumpus!" << endl;
            player.kill();
            cout << "Game over!" << endl;
            ended = true;
        }

        if (player.isSamePoint(getPitPos()))
        {
            cout << "Player is killed!" << endl;
            player.kill();
            cout << "Game over!" << endl;
            ended = true;
        }

        if (player.isSamePoint(gold_position))
        {
            cout << "Got the gold!" << endl;
            cout << "Game ended, you won!" << endl;
            ended = true;
        }
    }

    Position getPitPos()
    {
        return pit_position;
    }

    bool isOver()
    {
        return ended;
    }

};


int main()
{
    int c, wumpus_x, wumpus_y, gold_x, gold_y, pit_x, pit_y;
    // take the six integers input from file

    int posArr[6];
    int index=0;
    int i;
    ifstream is("WumpusInput.txt");
    while(index<6 and is>>i)
    {
        posArr[index++]=i;
    }
    is.close();
    wumpus_x=posArr[0];
    wumpus_y=posArr[1];
    gold_x=posArr[2];
    gold_y=posArr[3];
    pit_x=posArr[4];
    pit_y=posArr[5];


    srand(time(0));

    WumpusWorld w(wumpus_x,wumpus_y,gold_x,gold_y,pit_x,pit_y);
    //WumpusWorld w(wumpus_x,wumpus_y,gold_x,gold_y);
    //WumpusWorld w(wumpus_x,wumpus_y);
    //WumpusWorld w;
    w.showGameState();
    while (!w.isOver())
    {
        cout << "1: move forward" << endl;
        cout << "2: Turn left" << endl;
        cout << "3: Turn right" << endl;
        cout << "4: Shoot" << endl;
        cin >> c;
        if (c == 1)
        {
            w.moveForward();
        }
        else if (c == 2)
        {
            w.turnLeft();
        }
        else if (c == 3)
        {
            w.turnRight();
        }
        else if (c == 4)
        {
            w.shoot();
        }
    }
    return 0;
}





