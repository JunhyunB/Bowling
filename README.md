# Android Studio를 이용하여 Bowling Application 구현하기
===========================================================================
# Table of Contents  
- [1. GUI](#1-gui)
- [2. Model](#2-model)

## 1. GUI
------
Android Studio를 이용하여 아래 사진과 같이 Application의 GUI를 전반적으로 구현함.  

![layout](./GUI/layout.png)  

## 2. Model
--------
#### Python을 이용하여 물리 모델을 구현 후 이를 Java로 다시 작성 함.

![equation1](Model/eq1.gif)
![equation2](Model/eq2.gif)
![equation3](Model/eq3.gif)  
where ***u(t)*** is unit step function.  

첫 번째 식을 마찰과 구름을 고려하여 물리적으로 유도한 후, 변위를 구하기 위해 이를 적분하고, 볼링공의 시간에 따른 회전각 역시 마찬가지로 유도한다.  
이를 python 코드로 작성하였고, java로 변환하였다.  
공을 굴리는 각도도 마찬가지로 계산하여 좌표축을 회전변환하였다.  

현재 초기값으로 공의 초기 속도 및 방향 등을 임의로 입력하였는데,  
추후에 이를 스마트폰의 **가속도 센서, 자이로스코프 센서, 지자기 센서**   
이 3가지 센서를 이용하여 초기값들을 계산할 예정이다.
