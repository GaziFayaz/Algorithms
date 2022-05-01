#include<bits/stdc++.h>
using namespace std;

class Activity{

public:
    string activityName;
    int startTime;
    int finishTime;

    Activity(){}

    Activity(int startTime, int finishTime, int activityNum){
        this->startTime = startTime;
        this->finishTime = finishTime;
        this->activityName = this->activityName + "a" + to_string(activityNum);
    }


};

int main(){

    int n;
    cout<<"Enter the number of activities: ";
    cin>>n;
    Activity *activities = new Activity[n];

    for(int i=0; i<n; i++){
        int startTime, finishTime;
        cout<<"Enter the start time of activity no." <<i+1<<": ";
        cin>> startTime;
        cout<<"Enter the finish time of activity no."<<i+1<<": ";
        cin>>finishTime;
        activities[i] = Activity(startTime, finishTime, i+1);

    }


    for(int j=1; j<n; j++){
        Activity key = activities[j];
        int i = j-1;
        while(i>=0 && activities[i].finishTime>key.finishTime){
            activities[i+1] = activities[i];
            i--;
        }
        activities[i+1] =  key;
    }

    for(int i = 0; i<n; i++){
        cout<<"Activity name = "<<activities[i].activityName<<"\tStart Time = "<<activities[i].startTime
        <<"\tFinish Time = "<<activities[i].finishTime<<endl;
    }

    int maxPossibleActs = 1;
    Activity cur = activities[0];
    string message = "";
    message = message +"The activities are: "+activities[0].activityName+"("+to_string(activities[0].startTime)+
    ", "+ to_string(activities[0].finishTime)+")";
    for(int i = 1; i<n; i++){
        if(activities[i].startTime>=cur.finishTime){
            message = message + ", "+activities[i].activityName+"("+to_string(activities[i].startTime)+
            ", "+ to_string(activities[i].finishTime)+")";
            maxPossibleActs++;
            cur = activities[i];
        }
    }
    cout<<"\nMaximum number of possible activities are " <<maxPossibleActs<<endl;
    cout<<message<<endl;

}
