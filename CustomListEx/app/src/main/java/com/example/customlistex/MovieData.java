package com.example.customlistex;

public class MovieData {
    private String[] arrTitle = {
            "써니 (2011년)",
            "완득이 (2011년)",
            "괴물 (2006년)",
            "라디오스타 (2006년)",
            "비열한 거리 (2006년)",
            "왕의 남자 (2005년)",
            "아일랜드 (2005년)",
            "웰컴 투 동막골 (2005년)",
            "헬보이 (2004년)",
            "백 투 더 퓨쳐 (1985년)",
    };

    private Integer[] image = {
            R.drawable.mov01,
            R.drawable.mov02,
            R.drawable.mov03,
            R.drawable.mov04,
            R.drawable.mov05,
            R.drawable.mov06,
            R.drawable.mov07,
            R.drawable.mov08,
            R.drawable.mov09,
            R.drawable.mov10,
    };

    private String[] rating = {"9.11", "8.78", "8.62", "9.20", "8.79", "9.03", "8.81", "8.90", "7.05", "9.39"};
    private String[] genre = {"드라마", "드라마", "스릴러", "드라마", "느와르", "드라마", "SF", "드라마", "SF", "SF"};
    private int[] year = {2011, 2011, 2006, 2006, 2006, 2005, 2005, 2005, 2004, 1985};

    public String[] getArrTitle() {
        return arrTitle;
    }

    public Integer[] getImage() {
        return image;
    }

    public String[] getRating() {
        return rating;
    }

    public String[] getGenre() {
        return genre;
    }

    public int[] getYear() {
        return year;
    }
}

// 클래스를 나눠서 다시 코딩해보자.
