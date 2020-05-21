package com.example.addressbookex;

import java.util.ArrayList;

public class MemberList {
    private String[][] members = new String[][]{
            {"이대희", "010-9357-5262", "대구 달서구 상인화성파트드림"},
            {"박선영", "010-2803-5311", "대구 도원동 만수한의원"},
    };

    private String[] countNumber = new String[members.length];

    public String[][] getMembers() {
        return members;
    }

    public String[] getCountNumber() {
        return countNumber;
    }
}


