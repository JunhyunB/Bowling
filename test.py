import matplotlib
import matplotlib.pylab as plt
import numpy as np

# Parameters...
mass = 7 #kg
radius = 0.1085 # meter
I = 2 / 5 * mass * radius * radius # inertia of sphere
g = 9.8 # m/s^2
u = 1 # friction coeff.
t = 0.01 #time slice = 0.01 [sec]

x_position = 0 # fix
y_position = 0 # fix


# Variables

x = [0] 
y = [0] 

# initial velocity, calculated by sengsing values
init_x = 8  # average...
init_y = 0.1 # ?


# initial acc. result of sensoing values
x_acc = 6 
y_acc = 0.1

for i in range(400): # count 4 sec...

    rand = 0.9 # temp for test

    x_position = x_position + 0.5*x_acc*t*t + init_x*t # s = vt + 0.5at^2 suppose same acc. in timeslice
    y_position = y_position + 0.5*y_acc*t*t + init_y*t
    
    x.append(x_position)
    y.append(y_position)

    x_acc = x_acc * rand # update acc. calculated by friction, inertia, etc,.
    y_acc = y_acc * rand

    rand = rand - rand*0.1 # temp for test

hook = y[-1]
if hook > 0:
    hook_sign = "Left"
else:
    hook_sign = "Right"

print("Hook is %.4f meter to " % abs(hook) + hook_sign)

# Visualization
f1 = plt.figure(figsize=(10, 2))

ax = f1.add_subplot(1,1,1)

ax.set_xlim([0, 18.28])
ax.set_ylim([-0.5, 0.5])

plt.title("Bowling Lane")
plt.plot(x,y)
plt.show()