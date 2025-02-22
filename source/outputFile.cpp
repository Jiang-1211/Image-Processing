#include "../include/outputFile.h"
#include <bits/stdc++.h>
using namespace std;
#define MAX_PIXEL 255

void nameOutput(vector<string> &inputVec, int size)
{
    cout << "Number"
         << setw(7)
         << "Name" << endl;
    for (int i = 0; i < size; i++)
    {
        cout << setw(5)
             << i + 1
             << setw(4)
             << " : "
             << setw(4)
             << inputVec[i]
             << endl;
    }
}

void fileOutput(int **matrix, int length, int width, string fileName)
{
    ofstream output("image\\" + fileName + ".ppm");

    output << "P2" << '\n'
           << width << ' ' << length << '\n'
           << MAX_PIXEL << '\n';

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            output << matrix[i][j] << ' ';
        }
        output << '\n';
    }

    output.close();
}

void ASCIIOutput(int **matrix, int length, int width)
{
    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (matrix[i][j] > 127)
                cout << setw(2) << "@";
            else
                cout << setw(2) << "_";
        }
        cout << endl;
    }
}

void ASCIIFileOutput(int **matrix, int length, int width, string fileName)
{
    ofstream output("output\\" + fileName + ".txt");

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (matrix[i][j] > 127)
                output << setw(2) << "@";
            else
                output << setw(2) << "_";
        }
        output << endl;
    }

    output.close();
}