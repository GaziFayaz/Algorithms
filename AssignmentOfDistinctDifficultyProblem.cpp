#include<bits/stdc++.h>
using namespace std;

class Assignment{

public:
    string asnmtId;
    int asnmtDif;

    Assignment(){}

    Assignment(string asnmtId, int asnmtDif){
        this->asnmtId = asnmtId;
        this->asnmtDif = asnmtDif;
    }
};


main(){

    int n;
    cout<<"Enter the number of assignments: ";
    cin>>n;
    Assignment* asnmts = new Assignment[n];
    for(int i= 0; i<n; i++){
        string asnmtId;
        int asnmtDif;
        cout<<"Enter the assignment ID of assignment no."<<i<<": ";
        cin>>asnmtId;
        cout<<"Enter the assignment difficulty of assignment no."<<i<<": ";
        cin>>asnmtDif;
        asnmts[i] = Assignment(asnmtId, asnmtDif);

    }

    for(int i = 0; i<n; i++){
        cout<<"Assignment ID = "<<asnmts[i].asnmtId<<"\tDifficulty = "<<asnmts[i].asnmtDif<<endl;
    }

    for(int i = 1; i<n; i++){
        Assignment key = asnmts[i];
        int j= i-1;
        while(j>=0 && asnmts[j].asnmtDif<key.asnmtDif){
            asnmts[j+1] = asnmts[j];
            j--;
        }
        asnmts[j+1] = key;
    }
    int maxPoint = 0;
    cout<<"After sorting by difficulty:-"<<endl;
    for(int i=0; i<n; i++){
        cout<<"Assignment ID = "<<asnmts[i].asnmtId<<"\tDifficulty = "<<asnmts[i].asnmtDif<<endl;
    }

    for(int i = 1;i<=n; i++){
        maxPoint = maxPoint + asnmts[i-1].asnmtDif*(n-i);    //for the formula of points, difficulty*(number of assignments - week no.)
    }
    cout<<"Maximum Point = " <<maxPoint<<endl;
    cout<<"Assignment submission order: ";

    for(int i = 0 ;i<n; i++){
        cout<<asnmts[i].asnmtId<<" ";
    }
}
