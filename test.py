import matplotlib
import matplotlib.pylab as plt
import numpy as np

# Parameters...
mass = 7 #kg
radius = 0.1085 # meter
I = 2 / 5 * mass * radius * radius # inertia of sphere
g = 9.8 # m/s^2
u_k = 0.08 # friction coeff. 
t = 0.01 #time slice = 0.01 [sec]

x_position = 0 # fix
y_position = 0 # fix

x_w = 28.28 # [rad/s]
y_w = -7

x_theta = 0
y_theta = 0

# Variables
x = [0] 
y = [0] 

# initial velocity, calculated by sengsing values
init_x = 8  # average...
init_y = 0.1 # ?


# initial acc. result of sensoing values
#x_acc = 6 
#y_acc = 0.1

x_v = []
y_v = []

for i in range(400): # count 4 sec...


    x_v.append(x_w)
    y_v.append(y_w)

    #x_position = x_position + 0.5*x_acc*t*t + init_x*t # s = vt + 0.5at^2 suppose same acc. in timeslice
    #y_position = y_position + 0.5*y_acc*t*t + init_y*t
    x_temp = x_position
    y_temp = y_position

    x_theta_temp = x_theta
    y_theta_temp = y_theta

    x_position = x_position + init_x*t - 0.5*u_k*g*t*t + radius*x_w*t + (0.5*u_k*mass*g*radius*radius*t*t / I)
    y_position = y_position + init_y*t - 0.5*u_k*g*t*t + radius*y_w*t + (0.5*u_k*mass*g*radius*radius*t*t / I)

    x_theta = x_theta + x_w*t + (0.5*u_k*mass*g*radius*t*t / I)
    y_theta = y_theta +y_w*t + (0.5*u_k*mass*g*radius*t*t / I)

    x_w = (x_theta - x_theta_temp) / t
    y_w = (y_theta - y_theta_temp) / t
    
    x.append(x_position)
    y.append(y_position)

    init_x = (x_position - x_temp) / t
    init_y = (y_position - y_temp) / t


    #x_acc = x_acc * rand # update acc. calculated by friction, inertia, etc,.
    #y_acc = y_acc * rand

    #rand = rand - rand*0.1 # temp for test

    
'''
hook = y[-1]
if hook > 0:
    hook_sign = "Left"
else:
    hook_sign = "Right"

print("Hook is %.4f meter to " % abs(hook) + hook_sign)
'''

# Visualization
f1 = plt.figure(figsize=(10, 2))

ax = f1.add_subplot(1,1,1)

#ax.set_xlim([0, 18.28])
#ax.set_ylim([-0.5, 0.5])

ax.set_xlim([0,18.28])
ax.set_ylim([-1,1])

plt.title("Bowling Lane")
plt.plot(x,y)
plt.show()

plt.plot(x)
plt.show()

plt.plot(y)
plt.show()

plt.plot(x_v)
plt.show()

plt.plot(y_v)
plt.show()