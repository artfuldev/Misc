#include<iostream>
#include<conio.h>
using namespace std;
int main(void)
{
    float wa, wb, wc, wd, we, wf, wg;
	float bl, br, bla, blb, bra, brb;
	float tl, tr, tla, tlb, tra, trb;
	float sl, sr, sla, slb, sra, srb;
	float el, er, ela, elb, era, erb;
    int a[7], b[7], c[7], d[7], e[7], f[7], g[7];
	int le[7], re[7], lae[7], lbe[7], rae[7], rbe[7];
	int l[7], r[7], la[7], lb[7], ra[7], rb[7];
	int i;
    char st;
    cout<<"ILIFO 7-I 6-O Perceptron:"<<endl<<"Training:"<<endl;
    do
    {
    for(i=0;i<7;i++)
    {
          cout<<"Enter A,B,C,D,E,F,G,L,R,LA,LB,RA,RB for "<<i+1<<":";
          cin>>a[i]>>b[i]>>c[i]>>d[i]>>e[i]>>f[i]>>g[i]>>le[i]>>re[i]>>lae[i]>>lbe[i]>>rae[i]>>rbe[i];
          }
	cout<<"Enter bias [L]:";
    cin>>bl;
	cout<<"Enter threshold [L]:";
    cin>>tl;
	br=bla=blb=bra=brb=bl;
	tr=tla=tlb=tra=trb=tl;
	wa=wb=wc=wd=we=wf=wg=0;
    int ecount=0;
          for(i=0;i<7;i++)
          {
              sl=(wa*a[i])+(wb*b[i])+(wc*c[i])+(wd*d[i])+(we*e[i])+(wf*f[i])+(wg*g[i])+bl;
              if(sl>tl)
                     l[i]=1;
              else
                     l[i]=0;
              el=le[i]-l[i];
              if(e==0)
                ecount++;
              else
                  ecount--;
              wa=wa+(0.1*el*a[i]);
			  wb=wb+(0.1*el*b[i]);
			  wc=wc+(0.1*el*c[i]);
			  wd=wd+(0.1*el*d[i]);
			  we=we+(0.1*el*e[i]);
			  wf=wf+(0.1*el*f[i]);
			  wg=wg+(0.1*el*g[i]);
			  bl=bl+(0.1*el);
              if((i==6)&&(ecount<7))
                    i=-1;
              }
      cout<<"Weights fixed as:"<<endl;
      cout<<"wa="<<wa<<","<<"wb="<<wb<<","<<"wc="<<wc<<","<<"wd="<<wd<<","<<"we="<<we<<","<<"wf="<<wf<<","<<"wg="<<wg<<endl;
      cout<<"Check? [y/n]:";
      char ch;
      cin>>ch;
      while (ch!='n')
      {
            cout<<"Enter A,B,C,D,E,F,G:";
            cin>>a[0]>>b[0]>>c[0]>>d[0]>>e[0]>>f[0]>>g[0];
            sl=(wa*a[0])+(wb*b[0])+(wc*c[0])+(wd*d[0])+(we*e[0])+(wf*f[0])+(wg*g[0])+bl;
              if(sl>tl)
                     l[0]=1;
              else
                     l[0]=0;
            cout<<"Ouput:"<<l[0]<<endl;
            cout<<"Check again? [y/n]:";
            cin>>ch;
            }
      cout<<"Start over? [y/n]:";
      cin>>st;
      }while(st!='n');
      return 0;
}        
    
          
