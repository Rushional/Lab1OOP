#include "application.h"
#include <iostream>
#include "number.h"
#include "polinom.h"

using namespace std;

application::application()
{

}

int application::exec()
{
    int ch = 1, n;
    number a = 1, b = 2, c = 1;
    number x[2];
    while (ch!=0)
    {
        menu();
        cin>>ch;
            if (ch == 0) break;
        switch (ch)
        {
        case 1:
            cout<<"a= ";
            cin>>a;
            cout<<"b= ";
            cin>>b;
            cout<<"c= ";
            cin>>c;
            break;
        case 2:
        {
            polinom p(a, b, c);
            n = p.roots(x);
            cout<<x[0]<<' '<<x[1]<<endl;
        }
            break;
        case 3:
        {
            polinom p(a, b, c);
            cout<<"p(x) = "<<p;
        }
            break;
        default:
            break;
        }
    }
    cout<<"exec"<<endl;
    return 0;
}

void application::menu()
{
    cout<<"1. polinom coeff"<<endl;
    cout<<"2. roots"<<endl;
    cout<<"0. exit"<<endl;
}
