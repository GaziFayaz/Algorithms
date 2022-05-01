#include<bits/stdc++.h>
using namespace std;

class items{

public:
    int item_num=0;
    int weight=0;
    int benefit=0;
    double perUnitBenefit=0;

    void setPerUnitBenefit(){
        this->perUnitBenefit = (double)benefit/weight;
    }

};


int main()
{
    int n, s;
    cout<<"Enter the number of items: ";
    cin>>n;
    items item[n];
    cout<<"Enter the size of the knapsack: ";
    cin>>s;
    for(int i =0; i<n; i++){
        cout<<"Enter the weight of item no. "<< i<<": ";
        cin>>item[i].weight;
        item[i].item_num = i;
        /*
        for(int j = 0; j<n; j++){
            cout<<"stats of the item no." << j<< "\nItem no."<< item[j].item_num<<
            "\nItem weight: "<<item[j].weight<<"\nItem Benefit: "<<item[j].benefit<<
            "\nItem per unit benefit: "<<item[j].perUnitBenefit<<"\n\n";
        }*/
    }

    for(int i= 0; i<n; i++){
        cout<<"Enter the benefit of item no. "<< i<<": ";
        cin>>item[i].benefit;
    }

    for(int i=0; i<n; i++){
        item[i].setPerUnitBenefit();
    }
    /*for(int j = 0; j<n; j++){
            cout<<"stats of the item no." << j<< "\nItem no."<< item[j].item_num<<
            "\nItem weight: "<<item[j].weight<<"\nItem Benefit: "<<item[j].benefit<<
            "\nItem per unit benefit: "<<item[j].perUnitBenefit<<"\n\n";
    }*/



    items sortedItem[n];



    sortedItem[0] = item[0];
    for(int j =1; j<n; j++ ){
        sortedItem[j] = item[j];
        items key = sortedItem[j];
        int i = j-1;
        while(i>=0 && sortedItem[i].perUnitBenefit > key.perUnitBenefit){
            sortedItem[i+1] = sortedItem[i];
            i--;
        }
        sortedItem[i+1] = key;
    }

    for(int i=0; i<n; i++){
        cout<<sortedItem[i].perUnitBenefit<<" ";
    }

    int availWeigth = s;
    double totalValue=0;

    string messege = "By taking items: ";
    for(int i=n-1; i>=0; i--){
        if(availWeigth>=sortedItem[i].weight){
            availWeigth -=sortedItem[i].weight;
            totalValue+=sortedItem[i].benefit;
            messege = messege + to_string(sortedItem[i].item_num+1);
            if(availWeigth!= 0 && i!=0)messege = messege+", ";

        }

        else if(availWeigth<sortedItem[i].weight && availWeigth!=0){
            totalValue+= sortedItem[i].perUnitBenefit*availWeigth;

            messege= messege + "("+to_string(availWeigth) + " out of " + to_string(sortedItem[i].weight) + ") of " + to_string(sortedItem[i].item_num+1);
            availWeigth=0;
        }
    }
    cout<<"Maximum benefit: "<<totalValue<<endl;
    cout<<messege<<endl;

    return 0;


}

