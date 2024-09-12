#include <iostream>
#include <stack> 
#include <string>

using namespace std;

int main()
{
    int n;
    cin >> n;
    
    stack<int> stk;
    string str;
        
    for(int i=0; i<n; i++){
        cin >> str;
        
        if(str == "push") {
            int num=0;
            cin >> num;
            stk.push(num);

        } else if(str == "pop"){

            if(stk.empty()){
                cout << "-1" << endl;
            } 
else {
                cout << stk.top() << endl;
                stk.pop();
            }

            
        } else if(str == "size"){
            
            cout << stk.size() <<endl;
            
        } else if(str == "empty"){
            
            if(stk.empty()){
                cout << "1" << endl;                
            } 
else {                
                cout << "0" << endl;                
            }
            
        } else if(str == "top"){
            
            if(stk.empty()){
                cout << "-1" << endl;
            } 
else {
                cout << stk.top() << endl;
            }
        }
    }

    return 0;
}
