public class patient {

    String name;
    double date;
    double time;
    String consult;

    public patient(String n, double d, double t, String c){

        this.name = n;
        this.date = d;
        this.time = t;
        this.consult = c;

    }

        public void setName(String n){
            this.name = n;
        }
        public void setDate(double d){
            this.date = d;
        }
        public void setTime(double t){
            this.time = t;
        }
        public void setConsult(String c){
            this.consult = c;
        }

        public String getName(){
            return this.name;
        }
        public double getDate(){
            return this.date;
        }
        public double getTime(){
            return this.time;
        }
        public String getConsult(){
            return this.consult;
        }

            public String toString(){
                return "Patient "+name+": day: "+date+" - clock:"+time +":Type "+consult;
            }

            public boolean equals(Object obj){
                if(obj instanceof patient){
                    patient p = (patient) obj;
                        return name.equals(p.getName()) && date == p.getDate();
                }
                return false;
            }


}