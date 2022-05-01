#include<bits/stdc++.h>
using namespace std;

class Job{

public:

    string jobID;
    int deadline;
    int profit;

    Job(){

    }

    Job(string jobID, int deadline, int profit){
        this->jobID = jobID;
        this->deadline = deadline;
        this->profit = profit;
    }

};


main(){

    int n;
    cout<<"Enter the number of jobs: ";
    cin>>n;
    Job* jobs = new Job[n];
    for(int i = 0; i<n; i++){
        string jobID="";

        int deadline, profit;
        cout<<"Enter the job ID: ";
        cin>>jobID;
        cout<<"Enter the deadline for the job: ";
        cin>>deadline;
        cout<<"Enter the profit of the job";
        cin>>profit;

        jobs[i] = Job(jobID, deadline, profit);
    }

    /*
    for(int i = 0; i<n; i++){
        cout<<"Job ID = "<<jobs[i].jobID<<"\tDeadline = "<<jobs[i].deadline
        <<"\tProfit = "<<jobs[i].profit<<endl;
    }
    */

    for(int i=1; i<n; i++){
        Job key = jobs[i];
        int j = i-1;
        while(j>=0 && jobs[j].profit<key.profit){
            jobs[j+1] = jobs[j];
            j--;
        }
        jobs[j+1] = key;
    }

    /*
    cout<<"After Sorting by Profit:-"<<endl;
    for(int i = 0; i<n; i++){
        cout<<"Job ID = "<<jobs[i].jobID<<"\tDeadline = "<<jobs[i].deadline
        <<"\tProfit = "<<jobs[i].profit<<endl;
    }
    */


    int maxProfit= 0;

    //fill up taken job array with jobs in terms of deadline. A job can be scheduled to a day lower or equal to its deadline.
    Job* takenJob = new Job[n];
    for(int i = 0; i<n; i++){
        int j = jobs[i].deadline-1;
        int flag = 0;
        while(flag !=1 && j>= 0 ){
            if(takenJob[j].profit == 0){
                takenJob[j]= jobs[i];
                //cout<<"job taken on slot "<<j<<endl;
                maxProfit = maxProfit + jobs[i].profit;
                flag =1;
            }
            j--;
        }

    }
    /*
    cout<<"taken job array:"<<endl;
    for(int i = 0; i<n; i++){
            cout<<"Job ID = "<<takenJob[i].jobID<<"\tDeadline = "<<takenJob[i].deadline
            <<"\tProfit = "<<takenJob[i].profit<<endl;

    }
    */
    cout<<"Maximum profit is: "<<maxProfit<<endl;
    cout<<"Taken jobs:"<<endl;
    for(int i = 0; i<n; i++){
        if(takenJob[i].profit!=0){
            cout<<"Job ID = "<<takenJob[i].jobID<<"\tDeadline = "<<takenJob[i].deadline
            <<"\tProfit = "<<takenJob[i].profit<<endl;
        }
    }


}
