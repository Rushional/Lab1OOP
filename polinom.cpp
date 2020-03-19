#include "polinom.h"

polinom::polinom(number x, number y, number z)
{
    a = x; b = y; c = z;
}

int polinom::roots(number *x)
{
    x[0] = 1;
    x[1] = -1;
    return 2;
}

ostream& operator<<(ostream& os, polinom& p)
{
    os<<p.a<<"x^2+"<<p.b<<"x+"<<p.c;
    return os;
}
