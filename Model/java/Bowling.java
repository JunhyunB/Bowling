import java.util.ArrayList;

public class Bowling {
    public static void main(String[] args) {
        float mass = 7; // [kg]
        float radius = 0.1085; // [kg]
        float I = 2 / 5 * mass * radius * radius; // Inertia of sphere
        float g = 9.8; // [m/s^2]
        float u_k = 0.2; // friction coeff.
        float t = 0.01; // time slice = 0.01 [sec]

        float x_position = 0;
        float y_position = 0;

        float theta = 8; // throwing angle [degree]
        float PI = 3.141592; 
        float angle = theta * PI / 180;

        ArrayList x = new ArrayList<Float>();
        x.add(x_position);

        ArrayList y = new ArrayList<Float>();
        y.add(y_position);

        // initial velocity, calculated by sensing values
        float x_vel = 6;
        float y_vel = 0;

        float x_ang = 7;
        float y_ang = 12;
        float crit1 = 0;
        float crit2 = 0;
        int count = 0;
        int count2 = 0;

        // calculate x_position

        for(int i=0; i<400; i++){
            count = i;
            crit1 = x_vel - 0.5*g*t*(i+1);
            crit2 = x_vel - radius*x_ang;

            if (crit1<0) {
                break;
            }

            x_position = x_position + x_vel*t;
            x.add(x_position);

            x_ang = x_ang + (radius*u_k*mass*g*t) / I;

        }
        count2 = count;
        for(int j=0; j<400-count; j++){
            count2 = count2 + 1;
            crit2 = x_vel - radius*x_ang;

            if (crit2>0) {
                break;
            }

            x_position = x_position + x_vel*t + 0.5*u_k*g*t*t;

            x.add(x_position);

            x_vel = x_vel + u_k*g*t;

        }

        for(int k=0; k<400-count2;k++){
            x_position = x_position + x_vel*t;
            x.add(x_position);
        }

        //System.out.println(x.size());

        // calculate y_position
        for(int i=0; i<400; i++){
            count = i;
            crit1 = y_vel - 0.5*g*t*(i+1);
            crit2 = y_vel - radius*y_ang;

            if (crit1<0) {
                break;
            }

            y_position = y_position + y_vel*t;
            y.add(y_position);

            y_ang = y_ang + (radius*u_k*mass*g*t) / I;

        }
            count2 = count;
        for(int j=0; j<400-count; j++){
            count2 = count2 + 1;
            crit2 = y_vel - radius*y_ang;

            if (crit2>0) {
                break;
            }

            y_position = y_position + y_vel*t + 0.5*u_k*g*t*t;

            y.add(y_position);

            y_vel = y_vel + u_k*g*t;

        }

        for(int k=0; k<400-count2;k++){
            y_position = y_position + y_vel*t;
            y.add(y_position);
        }

        ArrayList x_ = new ArrayList<Float>();
        ArrayList y_ = new ArrayList<Float>();

        float x__;
        float y__;
        
        for(int i=0; i<y.size(); i++){
            x__ = Math.cos(angle) * (float) x.get(i) + Math.sin(angle) * (float) y.get(i);
            y__ = -1 * Math.sin(angle) * (float) x.get(i) + Math.cos(angle) * (float) y.get(i);

            x_.add(x__);
            y_.add(y__);
        }
        
        System.out.println("Calculating completed!");
    }
}