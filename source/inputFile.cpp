#include "../include/inputFile.h"
#include <bits/stdc++.h>
using namespace std;

string getType(ifstream &input)
{
    string fileType;

    getline(input, fileType);

    return fileType;
}

int getWidth(ifstream &input)
{
    char c;
    int width = 0;

    while (input.get(c))
    {
        if (c == ' ' || c == '\n')
        {
            break;
        }
        else
        {
            width = width * 10 + (c - '0');
        }
    }

    return width;
}

int getLength(ifstream &input)
{
    char c;
    int length = 0;

    while (input.get(c))
    {
        if (c == ' ' || c == '\n')
        {
            break;
        }
        else
        {
            length = length * 10 + (c - '0');
        }
    }

    return length;
}

int getMaxValue(ifstream &input)
{
    char c;
    int maxValue = 0;

    while (input.get(c))
    {
        if (c == ' ' || c == '\n')
        {
            break;
        }
        else
        {
            maxValue = maxValue * 10 + (c - '0');
        }
    }

    return maxValue;
}

void getValue(ifstream &input, int **matrix, int length, int width)
{
    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < width; j++)
        {
            input >> matrix[i][j];
        }
    }
}

#ifdef _WIN32
vector<string> getFileName()
{

    vector<string> str;

    _chdir("./image");
    system("dir *.* /b /on > ..\\output\\list.txt");
    _chdir("..");

    fstream f(".\\output\\list.txt", ios::in);

    for (string s; f >> s;)
    {
        str.push_back(s);
    }

    return str;
}
#elif __linux__ || __APPLE__
vector<string> getFileName()
{
    vector<string> str;

    _chdir("./image");
    system("ls -1 *.* > ../output/list.txt");
    _chdir("..");

    fstream f("./output/list.txt", ios::in);

    for (string s; f >> s;)
    {
        str.push_back(s);
    }

    return str;
}
#endif
