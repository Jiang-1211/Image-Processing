#include "../include/highResolutionASCIIArt.h"
#include <bits/stdc++.h>
using namespace std;
#define MAX_PIXEL 255

void highResolutionOutput(int **matrix, int length, int width)
{
    string list = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            cout << setw(2) << list[(68 - (matrix[i][j] * (list.length() - 2)) / MAX_PIXEL)];
        }
        cout << endl;
    }
}

void highResolutionFileOutput(int **matrix, int length, int width, string fileName)
{
    string list = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
    ofstream output("output/" + fileName + ".txt");

    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            output << setw(2) << list[(68 - (matrix[i][j] * (list.length() - 2)) / MAX_PIXEL)];
        }
        output << endl;
    }

    output.close();
}