import matplotlib
import matplotlib.pylab as plt
import numpy as np
import math

# Parameters ...
mass = 7 # [kg]
radius = 0.1085 # [meter]
g = 9.8 # [m/s^2]
I = 2 / 5 * mass * radius * radius # inertia of sphere
u_k = 0.2 # friction coeff.
t = 0.01 # time slice = 0.01 [sec]

x_position = 0
y_position = 0

theta = 8 # throwing angle [degree]
angle = theta * math.pi / 180 # [rad]

# Variables
# initial position
x = [x_position]
y = [y_position]

# initial velocity, calculated by sensing values
x_vel = 6 # average...
y_vel = 0

# initial angular vel.
x_ang = 7
y_ang = 12

# array
# velocity
x_v = [x_vel] 
y_v = [y_vel]
# angular velocity
x_w = [x_ang]
y_w = [y_ang]

test = []

# calculate x_position
for i in range(400):
    count = i

    crit1 = x_v[0]-0.5*g*t*(count+1)
    crit2 = x_vel - radius*x_ang

    if crit1 < 0:
        break

    x_position = x_position + x_vel*t

    x.append(x_position)
    
    x_vel = x_vel
    x_ang = x_ang + (radius*u_k*mass*g*t) / I

count2 = count

for j in range(400-count):
    count2 = count2 + 1
    crit2 = x_vel - radius*x_ang

    if crit2 > 0:
        break

    x_position = x_position + x_vel*t + 0.5*u_k*g*t*t

    x.append(x_position)

    x_vel = x_vel + u_k*g*t
    x_ang = x_ang


for k in range(400-count2):

    x_position = x_position + x_vel*t
    x.append(x_position)

    x_vel = x_vel
    x_ang = x_ang

# calculate y_position
for i in range(400):
    count = i

    crit1 = y_v[0]-0.5*g*t*(count+1)
    crit2 = y_vel - radius*y_ang

    if crit1 < 0:
        break

    y_position = y_position + y_vel*t

    y.append(y_position)
    
    y_vel = y_vel
    y_ang = y_ang + (radius*u_k*mass*g*t) / I

    test.append(crit2)

count2 = count

for j in range(400-count):

    count2 = count2 + 1
    crit2 = y_vel - radius*y_ang

    if crit2 > 0:
        break

    y_position = y_position + y_vel*t + 0.5*u_k*g*t*t

    y.append(y_position)

    y_vel = y_vel + u_k*g*t
    y_ang = y_ang

    test.append(crit2)

for k in range(400-count2):

    y_position = y_position + y_vel*t
    y.append(y_position)

    y_vel = y_vel
    y_ang = y_ang + (radius*u_k*mass*g*t) / I

    test.append(crit2)

# adapt throwing angle...

x_ = x
y_ = y

for i in range(len(x)):
    x[i] = math.cos(angle)*x_[i] + math.sin(angle)*y_[i]
    y[i] = -1*math.sin(angle)*x_[i] + math.cos(angle)*y_[i]

# Visualization
f1 = plt.figure(figsize=(10, 2))

ax = f1.add_subplot(1,1,1)

ax.set_xlim([0,18.28])
ax.set_ylim([-1,1])

plt.title("Bowling Lane")
plt.plot(x,y)
plt.show()

## 문제점 : y축 자꾸 양수 쭊쭊 올라감...