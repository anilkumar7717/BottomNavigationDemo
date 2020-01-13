package com.example.bottomnavigationdemo.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class AppNavigationController {
    private Activity activity;
    public FragmentManager fragmentManager;

    public AppNavigationController(Activity activity) {
        this.activity = activity;
        fragmentManager = activity.getFragmentManager();
    }


    public void backPressFrag() {
        if (fragmentManager.getBackStackEntryCount() <= 1) {
            activity.finish();
        } else {
            fragmentManager.popBackStack();
        }
    }


    public void clearAllFrag() {
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {
            fragmentManager.popBackStack();
        }
    }

    public void fragment(int container_body, Fragment fragment) {
        replaceFragment(container_body, fragment);
    }

    public void fragmentBackStack(int container_body, Fragment fragment) {
        replaceFragment(container_body, fragment);
    }


    public void replaceFragment(int container_body, Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = activity.getFragmentManager().popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped && activity.getFragmentManager().findFragmentByTag(backStateName) == null) {
            FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
            //FragmentTransaction ft = fragmentManager.beginTransaction();
            //  ft.setCustomAnimations(R.animator.fadein, R.animator.fadeout, R.animator.fadein, R.animator.fadeout);
            ft.replace(container_body, fragment, backStateName);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }


    public void replaceFragmentWithoutAnimation(int container_body, Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = activity.getFragmentManager().popBackStackImmediate(backStateName, 0);
        // if (!fragmentPopped && getActivity().getFragmentManager().findFragmentByTag(backStateName) == null) {
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        //FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(container_body, fragment, backStateName);
        ft.addToBackStack(null);
        ft.commit();
        // }
    }


    public void withoutBackStack(int container_body, Fragment fragment) {
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        //FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.replace(container_body, fragment);
        ft.commit();
    }


    @SuppressLint("ResourceType")
    public void withoutBackStackWithAnimation(int container_body, Fragment fragment) {
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        //FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(container_body, fragment);
        //ft.setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim);
        ft.commit();
    }

    public void f(Class activityClass) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
        activity.finish();
    }

    public void Wf(Class activityClass) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
    }


    public void fWA(Class activityClass) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    public void fWB(Class activityClass, Bundle bundle) {
        Intent intent = new Intent(activity, activityClass);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }


    public void WB(Class activityClass, Bundle bundle) {
        Intent intent = new Intent(activity, activityClass);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.finish();
    }
}
