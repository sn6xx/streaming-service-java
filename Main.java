package project.h;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Media> L = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        fillList();

        System.out.println("** Welcome To Our Special Program **");
        System.out.println("    Choose any service you want");

        int B;
        Subscription subscription = null;
        Client client = null;

        try {
            do {
                System.out.print("\n1- Add New Movie\n"
                        + "2- Add New Episode\n"
                        + "3- Show Movies\n"
                        + "4- Show Series\n"
                        + "5- Show Podcast\n"
                        + "6- Show ALL\n"
                        + "7- Remove Media\n"
                        + "8- New Account\n"
                        + "9- New Subscription\n"
                        + "10- Show Subscription\n"
                        + "11- Cancel Subscription\n"
                        + "12- Show GUI\n"
                        + "13- Read From Text File\n"
                        + "14- Exit\n"
                        + "Your option : ");

                B = input.nextInt();

                switch (B) {
                    case 1:
                        System.out.print("Enter Movie number: ");
                        int j = input.nextInt();
                        if (j <= 0) {
                            System.err.println("invalid number!");
                        }
                        System.out.print("Enter Movie Title: ");
                        String title = input.nextLine();
                        input.nextLine();
                        System.out.print("Enter Movie Type: ");
                        String type = input.nextLine();
                        System.out.print("Enter Realese Year: ");
                        int releaseYear = input.nextInt();
                        System.out.print("Enter Runtime : ");
                        int runtime = input.nextInt();
                        if (runtime <= 0) {
                            System.err.println("invalid number!");
                            break;
                        }

                        System.out.print("Enter Director Id: ");
                        int Id = input.nextInt();
                        if (Id <= 0) {
                            System.err.println("invalid number!");
                        }
                        System.out.print("Enter Director Name: ");
                        String Name = input.nextLine();
                        input.nextLine();

                        System.out.print("Enter Director Email: ");
                        String Email = input.nextLine();
                        System.out.print("Enter Director Experience Years: ");
                        int ExpYears = input.nextInt();

                        //create objects ---> static binding
                        Director director = new Director(Id, Name, Email, ExpYears);
                        Media movie = new Movie(j, title, type, releaseYear, director, runtime);
                        L.add(movie); 
                        System.out.println(movie);
                        System.out.println("\u001B[32m" +"New movie has been added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Series number : ");
                        int num = input.nextInt();
                        if (num <= 0) {
                            System.err.println("invalid number!");
                        }
                        Series series = null;
                        for (Media e : L) {
                            if (e instanceof Series) {
                                if (e.getNUM() == num) {
                                    series = (Series) e;
                                    //sub = (sub) super
                                    break;
                                }
                            }
                        }

                        if (series == null) {
                            System.err.println("Series with number " + num + " was not found!");
                            break;
                        }

                        input.nextLine();
                        System.out.print("Enter Episode Title: ");
                        String Title = input.nextLine();
                        System.out.print("Enter Episode Duration in minutes: ");
                        int Duration = input.nextInt();
                        if (Duration <= 0) {
                            System.err.println("Invalid duration!");
                            break;
                        }
                        System.out.print("Enter Episode Season number: ");
                        int Season = input.nextInt();

                        Episode episode = new Episode(Title, Duration, Season);

                        //update series episodes
                        Episode[] episodes = series.getEpisodes(); //يضيف عالحالية
                        if (episodes == null) {
                            episodes = new Episode[1];
                            episodes[0] = episode;
                            series.setEpisodes(episodes);//update

                        } else {
                            Episode[] episodesB = new Episode[episodes.length + 1];
                            int i = 0;
                            for (i = 0; i < episodes.length; i++) {
                                episodesB[i] = episodes[i];
                            }
                            episodesB[i] = episode;
                            series.setEpisodes(episodesB);//update
                        }
                        series.displayEpisodes();
                        System.out.println("\u001B[32m" + "Episode has been added successfully!");
                        break;

                    case 3:
                        System.out.println("*** All Movies  ***");
                        for (Media e : L) {
                            if (e instanceof Movie) {
                                System.out.println(e);//toString
                                System.out.println("--------------------------");
                            }
                        }
                        break;

                    case 4:
                        System.out.println("*** All Series ***");
                        for (Media e : L) {
                            if (e instanceof Series) {
                                System.out.println(e);//toString
                                ((Series) e).displayEpisodes();
                                System.out.println("--------------------------");
                            }
                        }
                        break;

                    case 5:
                        System.out.println("*** All PODCAST ***");
                        for (Media e : L) {
                            if (e instanceof Podcast) {
                                System.out.println(e);//toString
                                System.out.println("--------------------------");
                            }
                        }
                    case 6:
                        System.out.println("*** All MEDIA ***");
                        for (Media e : L) {
                            System.out.println(e);//toString
                            System.out.println("--------------------------");
                        }

                        break;

                    case 7:
                        System.out.print("Enter Media number : ");
                        int num2 = input.nextInt();
                        int index = -1;
                        for (int i = 0; i < L.size(); i++) {
                            if (L.get(i).getNUM() == num2) {
                                index = i;
                                break;

                            }

                        }
                        if (index == -1) {
                            System.err.println("Media with number " + num2 + " is not found!");
                            break;//stop
                        }

                        L.remove(index);
                        System.out.println("\u001B[32m" + "Media with number " + num2 + " has been remove successfully!");
                        break;

                    case 8:
                        System.out.print("Enter your id: ");
                        int clientId = input.nextInt();
                        if (clientId <= 0) {
                            System.err.println("invalid number");
                        }
                        System.out.print("Enter your name: ");
                        String clientName = input.nextLine();
                        input.nextLine();
                        System.out.print("Enter your email: ");
                        String clientEmail = input.nextLine();
                        System.out.print("Enter your phone: ");
                        int clientPhone = input.nextInt();
                        System.out.print("Enter your password: ");
                        String clientPassword = input.nextLine();

                        client = new Client(clientId, clientName, clientEmail, clientPhone, clientPassword);
                        System.out.println(client);//toString
                        System.out.println("\u001B[32m" + "Your account has been created successfully.");
                        break;

                    case 9:

                        if (client == null) {
                            System.out.println("Please create an account first!");
                            break;
                        }

                        System.out.println("Chooes The Plan You Want");

                        System.out.println("1- THE BASIC \n" 
                                + "Video quality :'Good' \n"
                                + "The precision : '720p' \n"
                                + "The number of devices : '2' \n"
                                + "The price : '35'\n\n"
                                + "2- THE SPECIAL  \n"
                                + "Video quality 'excellent' \n"
                                + "The precision : '1080p'\n"
                                + "The number of devices : '4' \n"
                                + "The price : '65'\n\n"
                                + "3- THE VIP Plan \n"
                                + "Video quality 'The best' \n"
                                + "The precision : '4K+HDR'\n"
                                + "The number of devices : '6' \n"
                                + "The price : '95'\n"
                                + "Your option : ");

                        int numPlan = input.nextInt();

                        System.out.println("Enter Subscription Date");
                        System.out.print("Year: ");
                        int year = input.nextInt();
                        System.out.print("Month: ");   //**if statment**
                        int month = input.nextInt();
                        System.out.print("Day: ");
                        int day = input.nextInt();
                        Date date = new Date(day, month, year);

                        System.out.print("How many months do you want to subscribe? ");
                        int m = input.nextInt();
                        subscription = new Subscription(null, null, numPlan, m, null);

                        System.out.println("Your Total Price is : " + subscription.calcPayment() + "SAR");

                        System.out.println();
                        System.out.println("*** Payment ***");
                        input.nextLine();
                        System.out.print("Enter card holder name: ");
                        String paymentName = input.nextLine();
                        System.out.print("Enter payment type(Visa, ApplePay etc..): ");
                        String paymentType = input.nextLine();

                        System.out.print("Confirm Subscription? (Y/N): ");
                        char answer = input.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {
                            Payment payment = new Payment(paymentName, paymentType);
                            subscription = new Subscription(client, date, numPlan, m, payment);
                            subscription.setStatus("Active");
                            subscription.print();
                            System.out.println("\u001B[32m" + "*** Your Subscription has been confirmed! ***");
                        } else {
                            System.out.println("Your Subscription has been cancelled!");
                        }

                        break;

                    case 10:
                        if (subscription == null) {
                            System.out.println("You don't have any subscription yet!");
                        } else {
                            subscription.print();
                        }
                        break;

                    case 11:
                        if (subscription != null) {
                            System.out.print("Are you sure you want to cancel your Subscription? (Y/N): ");
                            answer = input.next().charAt(0);
                            if (answer == 'y' || answer == 'Y') {
                                subscription.setStatus("Cancelled");
                                subscription.print();
                                System.out.println("Your Subscription has been cancelled!");
                            } else {
                                System.out.println("Your Subscription is still Active!");
                            }
                        } else {
                            System.out.println("No subscriptions yet!");
                        }
                        break;

                    case 12:
                        GUI.main(null);

                    case 13:
                        ReadTextFiles r = new ReadTextFiles();
                        r.openFile("project-H-.txt");
                        r.readFile();
                        r.closeFile();
                        break;

                    case 14: 
                        WriteTextFiles w = new WriteTextFiles();
                        w.openFile("project-H-.txt");
                        for (Media k : L) {
                            w.writeFile(k);
                        }
                        w.closeFile();
                        System.out.println("\u001B[32m" + "Date saved successfully to project-H- file");
                        System.out.println("\u001B[32m" + "Thank you for using our program");

                        break;
                    default:
                        System.err.println("Invalid Option!");

                }

            } while (B != 14);
        } catch (InputMismatchException ex) {
            System.err.println("invalid input!");

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("invalid index!");
        } catch (NullPointerException ex) {
            System.err.println("invalid object!");
        } catch (Throwable ex) {
            System.err.println("invalid downcasting!");
        }
    }

    public static void fillList() {

        Media m1 = new Movie(10, "The Call", "vagueness", 2020, new Director(8840, "Chung-Hyun Lee", "chung@mail.com", 12), 112);
        Media m2 = new Movie(20, "Fabricated City ", "Action", 2017, new Director(9901, "Park Kwang-hyun", "park@mail.com", 16), 126);
        Media m3 = new Movie(30, "Black List ", "Drama", 2007, new Director(7701, "Jim", "Jim@mail.com", 9), 120);

        Media s1 = new Series(40, "Breaking Bad", "Crime", 2008, new Director(7850, "Vince Gilligan", "vince@mail.com", 20), 5, 62, null);
        Media s2 = new Series(50, "Prison Break", "Crime", 2005, new Director(3303, "Paul Scheuring", "paul@mail.com", 3), 5, 90, null);
        Media s3 = new Series(60, "13Resines", "Suspense", 2011, new Director(2200, "Max", "Max@mail.com", 11), 3, 71, null);

        Media p1 = new Podcast(70, "Felony", "Crime", 2021, new Director(2290, "Mohammad Al-Biz", "mohmad@gmail.com ", 14), "http://wwwree", "Mohamed Al-Shaibani");
        Media p2 = new Podcast(80, "Unquiet mind", "diverse", 2018, new Director(3340, "Mubarak Al Zawbaa", "Mubarak@gmail.com", 6), "http://rttyvda", "Amal Al-Tamimi");
        Media p3 = new Podcast(90, "Consult with sarah", "educational", 2020, new Director(2350, "Sarah", "Sarah@gmail.com", 7), "http://ssaraaahxx", "Ahmad");

        L.add(m1);
        L.add(m2);
        L.add(m3);
        L.add(s1);
        L.add(s2);
        L.add(s3);
        L.add(p1);
        L.add(p2);
        L.add(p3);

    }

}
