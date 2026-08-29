#include <iostream>
#include <string>
using namespace std;

int main() {
    string s = to_string(0b1001);

    cout << s << endl; // Output: 9
    cout << to_string(123.4) << endl; // Output: 123.400000

    return 0;
}