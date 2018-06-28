package com.example.nds.podborodejdi2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageSwitcher;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    Class fragmentClass;
    android.support.v4.app.Fragment myFragment;
    private int kolv0_footbolok=3,curr_temp =13,kolv0_shtani=3,kolv0_obuv=3;
    AddFragment addFragment;
    LookFragment lookFragment;
    PodborFragment podborFragment;
    android.support.v4.app.FragmentManager fragmentManager;

    public void onClick(View view) {
        switch (view.getId()) {


        }

    }

    static class Footbolka
    {
        int id=0,min_temp=0,max_temp=0;
        String nazvanie="";
        private void setFootbolka(int id,String nazvanie,int min_temp,int max_temp)
        {
            this.id=id;
            this.nazvanie=nazvanie;
            this.min_temp = min_temp;
            this.max_temp = max_temp;
        }
    }
    static class Shtani
    {
        int id=0,min_temp=0,max_temp=0;
        String nazvanie="";
        private void setShtani(int id,String nazvanie,int min_temp,int max_temp)
        {
            this.id=id;
            this.nazvanie=nazvanie;
            this.min_temp = min_temp;
            this.max_temp = max_temp;
        }
    }
    static class Obuv
    {
        int id=0,min_temp=0,max_temp=0;
        String nazvanie="";
        private void setObuv(int id,String nazvanie,int min_temp,int max_temp)
        {
            this.id=id;
            this.nazvanie=nazvanie;
            this.min_temp = min_temp;
            this.max_temp = max_temp;
        }
    }

    private Footbolka[] footbolkas=new Footbolka[20];
    private Footbolka[] footbolkas_podhod=new Footbolka[20];
    private Shtani[] shtanis=new Shtani[20];
    private Shtani[] shtanis_podhod=new Shtani[20];
    private Obuv[] obuvs=new Obuv[20];
    private Obuv[] obuvs_podhod=new Obuv[20];

    DataFromActivityToFragment dataFromActivityToFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        NavigationView nvDrawer = (NavigationView)findViewById(R.id.nv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);

        for(int i=0;i<kolv0_footbolok;i++) {
            footbolkas[i]=new Footbolka();
        }
        footbolkas[0].setFootbolka(R.drawable.footbolka1,"footbolka1",5, 15);
        footbolkas[1].setFootbolka(R.drawable.footbolka2,"footbolka2",10, 20);
        footbolkas[2].setFootbolka(R.drawable.footbolka3,"footbolka3",15, 25);
        footbolkas_podhod=PodobratFootbolki(kolv0_footbolok,footbolkas,curr_temp);

        for(int i=0;i<kolv0_shtani;i++) {
            shtanis[i]=new Shtani();
        }
        shtanis[0].setShtani(R.drawable.shtani1,"shtani1",5, 15);
        shtanis[1].setShtani(R.drawable.shtani2,"shtani2",10, 20);
        shtanis[2].setShtani(R.drawable.shtani3,"shtani3",15, 25);
        shtanis_podhod=PodobratShtani(kolv0_shtani,shtanis,curr_temp);

        for(int i=0;i<kolv0_obuv;i++) {
            obuvs[i]=new Obuv();
        }
        obuvs[0].setObuv(R.drawable.obuv1,"obuv1",5, 15);
        obuvs[1].setObuv(R.drawable.obuv2,"obuv2",10, 20);
        obuvs[2].setObuv(R.drawable.obuv3,"obuv3",15, 25);
        obuvs_podhod=PodobratObuv(kolv0_footbolok,obuvs,curr_temp);

        myFragment = null;
        fragmentClass=PodborFragment.class;
        try{
            myFragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frlya,myFragment).commit();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectIterDrawer (MenuItem menuItem){

        switch (menuItem.getItemId()){
            case R.id.add:
                fragmentClass = AddFragment.class;
                break;
            case R.id.look:
                fragmentClass = LookFragment.class;
                break;
            case R.id.podbor:
                fragmentClass=PodborFragment.class;
                /*if(footbolkas_podhod!=null)
                    dataFromActivityToFragment.SendFootbolki(true,footbolkas_podhod);
                else
                    dataFromActivityToFragment.SendFootbolki(false,footbolkas_podhod);
                if(shtanis_podhod!=null)
                    dataFromActivityToFragment.SendShtani(true,shtanis_podhod);
                else
                    dataFromActivityToFragment.SendShtani(false,shtanis_podhod);
                if(obuvs_podhod!=null)
                    dataFromActivityToFragment.SendObuv(true,obuvs_podhod);
                else
                    dataFromActivityToFragment.SendObuv(false,obuvs_podhod);*/
                break;


        }
        try{
            myFragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        fragmentManager.beginTransaction().replace(R.id.frlya,myFragment).commit();

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();
    }




    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectIterDrawer(item);
                return true;
            }
        });
    }

    Footbolka[] PodobratFootbolki(int kol_foot,Footbolka[] footbolki, int curr_temp)
    {
        Footbolka[] podhod = new Footbolka[kol_foot];
        int kol_pod_footb=0;
        podhod[0]=new Footbolka();
        for(int i=0;i<kol_foot;i++){
            if(footbolki[i].min_temp<curr_temp&&footbolki[i].max_temp>curr_temp)
            {
                podhod[kol_pod_footb]=footbolki[i];
                kol_pod_footb++;
            }
        }
        if(kol_pod_footb>0)
        return podhod;
        else
            return null;
    }

    Shtani[] PodobratShtani(int kol_shtan,Shtani[] shtanis,int curr_temp)
    {
        Shtani[] podhod = new Shtani[kol_shtan];
        int kol_pod_shtan=0;
        podhod[0]=new Shtani();
        for(int i=0; i<kol_shtan;i++){
            if(shtanis[i].min_temp<curr_temp&&shtanis[i].max_temp>curr_temp)
            {
                podhod[kol_pod_shtan]=shtanis[i];
                kol_pod_shtan++;
            }
        }
        if(kol_pod_shtan>0)
            return podhod;
        else
            return null;
    }
    Obuv[] PodobratObuv(int kol_obuv,Obuv[] obuvs,int curr_temp)
        {
            Obuv[] podhod = new Obuv[kol_obuv];
            int kol_pod_obuv=0;
            podhod[0]=new Obuv();
            for(int i=0; i<kol_obuv;i++){
                if(obuvs[i].min_temp<curr_temp&&obuvs[i].max_temp>curr_temp)
                {
                    podhod[kol_pod_obuv]=obuvs[i];
                    kol_pod_obuv++;
                }
            }
            if(kol_pod_obuv>0)
                return podhod;
            else
                return null;
        }

        Footbolka[] getAllFootbolkas()
        {
            return footbolkas;
        }

        Shtani[] getAllShtanis()
        {
            return shtanis;
        }

        Obuv[] getAllObuvs()
        {
            return obuvs;
        }

        public Footbolka getFootbolka()
        {
            return footbolkas[0];
        }

        public Shtani getShtani()
        {
            return shtanis[0];
        }

        public Obuv getObuv()
        {
            return obuvs[0];
        }

    public interface DataFromActivityToFragment{
        void SendFootbolki(boolean est, Footbolka[] footbolkas);
        void SendShtani(boolean est,Shtani[] shtanis);
        void SendObuv(boolean est,Obuv[] obuvs);
    }
}
