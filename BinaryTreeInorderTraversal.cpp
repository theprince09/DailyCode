/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]

Output: [1,3,2]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,2,6,5,7,1,3,9,8]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]
*/

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// Definition of TreeNode
struct TreeNode {
    int val;
    TreeNode *left, *right;
    
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// Function for Inorder Traversal (Left, Root, Right)
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        inorderHelper(root, result);
        return result;
    }

private:
    void inorderHelper(TreeNode* root, vector<int>& result) {
        if (!root) return;
        inorderHelper(root->left, result);
        result.push_back(root->val);
        inorderHelper(root->right, result);
    }
};

// Function to Build Tree from User Input (Level Order)
TreeNode* buildTree() {
    cout << "Enter root value (-1 for NULL): ";
    int val;
    cin >> val;
    if (val == -1) return nullptr;

    TreeNode* root = new TreeNode(val);
    queue<TreeNode*> q;
    q.push(root);

    while (!q.empty()) {
        TreeNode* current = q.front();
        q.pop();

        cout << "Enter left child of " << current->val << " (-1 for NULL): ";
        int leftVal;
        cin >> leftVal;
        if (leftVal != -1) {
            current->left = new TreeNode(leftVal);
            q.push(current->left);
        }

        cout << "Enter right child of " << current->val << " (-1 for NULL): ";
        int rightVal;
        cin >> rightVal;
        if (rightVal != -1) {
            current->right = new TreeNode(rightVal);
            q.push(current->right);
        }
    }
    return root;
}

int main() {
    TreeNode* root = buildTree();
    
    Solution solution;
    vector<int> inorderResult = solution.inorderTraversal(root);

    cout << "Inorder Traversal: ";
    for (int num : inorderResult) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
