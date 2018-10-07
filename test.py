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

x_w = 7.76 # [rad/s]
y_w = 0

x_theta = 0
y_theta = 0

# Variables
x = [0] 
y = [0] 

# initial velocity, calculated by sengsing values
init_x = 8  # average...
init_y = 0 # ?

x_v = []
y_v = []

for i in range(400): # count 4 sec...

    count = i

    x_v.append(x_w)
    y_v.append(y_w)

    x_temp = x_position
    y_temp = y_position

    x_theta_temp = x_theta
    y_theta_temp = y_theta

    x_position = x_position + init_x*t
    y_position = y_position + init_y*t

    x_v = init_x
    y_v = init_y
    
    x.append(x_position)
    y.append(y_position)

    if (init_x - u_k*g*count*t) < 0:
        for i in range(400-count):
            #x_v.append(x_w)
            #y_v.append(y_w)

            x_v = init_x + u_k*g*t
            y_v = init_y + u_k*g*t

            x_temp = x_position
            y_temp = y_position

            x_position = x_position + init_x*t + 0.5*u_k*g*t*t
            y_position = y_position + init_y*t + 0.5*u_k*g*t*t
            
            x.append(x_position)
            y.append(y_position)
            #if (init_x > radius*)

        break;

    

    
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