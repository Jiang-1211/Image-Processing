#ifndef _INPUTFILE_H_
#define _INPUTFILE_H_
#include <bits/stdc++.h>
#include <direct.h>
#ifdef _WIN32
#include <windows.h>
#elif __linux__
#include <unistd.h>
#endif
using namespace std;

string getType(ifstream &input);

int getWidth(ifstream &input);

int getLength(ifstream &input);

int getMaxValue(ifstream &input);

void getValue(ifstream &input, int **matrix, int length, int width);

vector<string> getFileName();

#endif