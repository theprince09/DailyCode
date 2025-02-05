/*
A kingdom consists of a king, his children, his grandchildren, and so on. Every once in a while, someone in the family dies or a child is born.

The kingdom has a well-defined order of inheritance that consists of the king as the first member. Let's define the recursive function Successor(x, curOrder), which given a person x and the inheritance order so far, returns who should be the next person after x in the order of inheritance.

Successor(x, curOrder):
    if x has no children or all of x's children are in curOrder:
        if x is the king return null
        else return Successor(x's parent, curOrder)
    else return x's oldest child who's not in curOrder
For example, assume we have a kingdom that consists of the king, his children Alice and Bob (Alice is older than Bob), and finally Alice's son Jack.

In the beginning, curOrder will be ["king"].
Calling Successor(king, curOrder) will return Alice, so we append to curOrder to get ["king", "Alice"].
Calling Successor(Alice, curOrder) will return Jack, so we append to curOrder to get ["king", "Alice", "Jack"].
Calling Successor(Jack, curOrder) will return Bob, so we append to curOrder to get ["king", "Alice", "Jack", "Bob"].
Calling Successor(Bob, curOrder) will return null. Thus the order of inheritance will be ["king", "Alice", "Jack", "Bob"].
Using the above function, we can always obtain a unique order of inheritance.

Implement the ThroneInheritance class:

ThroneInheritance(string kingName) Initializes an object of the ThroneInheritance class. The name of the king is given as part of the constructor.
void birth(string parentName, string childName) Indicates that parentName gave birth to childName.
void death(string name) Indicates the death of name. The death of the person doesn't affect the Successor function nor the current inheritance order. You can treat it as just marking the person as dead.
string[] getInheritanceOrder() Returns a list representing the current order of inheritance excluding dead people.
 

Example 1:

Input
["ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", "getInheritanceOrder", "death", "getInheritanceOrder"]
[["king"], ["king", "andy"], ["king", "bob"], ["king", "catherine"], ["andy", "matthew"], ["bob", "alex"], ["bob", "asha"], [null], ["bob"], [null]]
Output
[null, null, null, null, null, null, null, ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"], null, ["king", "andy", "matthew", "alex", "asha", "catherine"]]

Explanation
ThroneInheritance t= new ThroneInheritance("king"); // order: king
t.birth("king", "andy"); // order: king > andy
t.birth("king", "bob"); // order: king > andy > bob
t.birth("king", "catherine"); // order: king > andy > bob > catherine
t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
t.getInheritanceOrder(); // return ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
t.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
t.getInheritanceOrder(); // return ["king", "andy", "matthew", "alex", "asha", "catherine"]
 

Constraints:

1 <= kingName.length, parentName.length, childName.length, name.length <= 15
kingName, parentName, childName, and name consist of lowercase English letters only.
All arguments childName and kingName are distinct.
All name arguments of death will be passed to either the constructor or as childName to birth first.
For each call to birth(parentName, childName), it is guaranteed that parentName is alive.
At most 105 calls will be made to birth and death.
At most 10 calls will be made to getInheritanceOrder.
*/

#include <iostream>
#include <vector>
#include <map>

using namespace std;

class ThroneInheritance {
public:
    struct Node {
        string name;
        vector<Node*> children;
        Node(string s) {
            name = s;
        }
    };

    Node* root = NULL;
    map<string, Node*> m;

    void getOrder(vector<string>& ans, Node* curr) {
        if (curr->name != "")
            ans.push_back(curr->name);
        for (Node* child : curr->children)
            getOrder(ans, child);
    }

    ThroneInheritance(string kingName) {
        root = new Node(kingName);
        m[kingName] = root;
    }

    void birth(string parentName, string childName) {
        Node* nodePtr = m[parentName];
        Node* node = new Node(childName);
        nodePtr->children.push_back(node);
        m[childName] = node;
    }

    void death(string name) {
        if (m.find(name) != m.end()) {
            m[name]->name = "";
        }
    }

    vector<string> getInheritanceOrder() {
        vector<string> ans;
        getOrder(ans, root);
        return ans;
    }
};

int main() {
    string kingName;
    cout << "Enter the name of the king: ";
    cin >> kingName;

    ThroneInheritance throne(kingName);

    int choice;
    do {
        cout << "\nMenu:\n";
        cout << "1. Birth (Add Child)\n";
        cout << "2. Death (Remove from Inheritance)\n";
        cout << "3. Get Inheritance Order\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 1) {
            string parentName, childName;
            cout << "Enter Parent's Name: ";
            cin >> parentName;
            cout << "Enter Child's Name: ";
            cin >> childName;
            throne.birth(parentName, childName);
        } 
        else if (choice == 2) {
            string name;
            cout << "Enter Name to Mark as Dead: ";
            cin >> name;
            throne.death(name);
        } 
        else if (choice == 3) {
            vector<string> order = throne.getInheritanceOrder();
            cout << "Current Inheritance Order: ";
            for (string name : order) {
                cout << name << " ";
            }
            cout << endl;
        }
    } while (choice != 4);

    cout << "Program exited.\n";
    return 0;
}


