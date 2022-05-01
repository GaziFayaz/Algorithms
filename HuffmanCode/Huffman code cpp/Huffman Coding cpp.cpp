#include<bits/stdc++.h>
using namespace std;

class Node{

public:
    char data;
    int freq;
    Node* right;
    Node* left;

    Node(char data, int freq){
        left = right = nullptr;
        this->data = data;
        this->freq = freq;
    }
};

class compare {

public:

    bool operator()(Node* l, Node* r){

        return (l->freq > r->freq);
    }
};


void printCode(Node* root, string str){

    if(root == nullptr){
        return ;
    }
    if(root->data!='$'){
        cout<<root->data<<": "<<str<<endl;
    }

    printCode(root->left, str+"0");
    printCode(root->right, str+"1");

}

void HuffmanCodes(char data[], int freq[], int size){

    Node* left, *right, *top;

    priority_queue<Node*, vector<Node*>, compare> minHeap;

    for(int i= 0; i<size; i++){
        minHeap.push(new Node(data[i], freq[i]));
    }

    while(minHeap.size()!=1){

        left = minHeap.top();
        minHeap.pop();

        right = minHeap.top();
        minHeap.pop();

        top = new Node('$', left->freq + right->freq);

        top->left = left;
        top->right = right;

        minHeap.push(top);
    }

    printCode(minHeap.top(), "");
}

int main(){
    int n;
    cout<<"Enter the number of letters: ";
    cin>>n;
    char arr[n];
    int freq[n];
    for(int i=0; i<n; i++){
        cout<<"Enter the letter no."<<i<<": ";
        cin>>arr[i];
        cout<<"Enter the frequency of the letter: ";
        cin>>freq[i];
    }
    cout<<endl;

    int size = sizeof(arr)/sizeof(arr[0]);

    HuffmanCodes(arr, freq, size);

    return 0;
}
