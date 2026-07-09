// Last updated: 09/07/2026, 10:13:48
#include <vector>
#include <string>
#include <algorithm>

class Solution {
public:
    string largestNumber(vector<int>& nums) {
        // Convert all integers to strings
        vector<string> asStrings;
        for (int num : nums) {
            asStrings.push_back(to_string(num));
        }
        
        // Sort using the custom comparator
        sort(asStrings.begin(), asStrings.end(), [](const string& a, const string& b) {
            return a + b > b + a;
        });
        
        // Edge case: If the largest number is "0", the entire result is just "0"
        if (asStrings[0] == "0") {
            return "0";
        }
        
        // Combine the sorted strings into the final answer
        string largestNum = "";
        for (const string& str : asStrings) {
            largestNum += str;
        }
        
        return largestNum;
    }
};
