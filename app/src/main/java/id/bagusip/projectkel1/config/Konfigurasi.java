package id.bagusip.projectkel1.config;

public class Konfigurasi
{
    //EMPLOYEES
    //GET DIVISION
    public static final String URL_GET_DIVISION = "http://192.168.100.7/teamOneProject/register/get_division.php";
    //GET BRANCH
    public static final String URL_GET_BRANCH = "http://192.168.100.7/teamOneProject/register/get_branch.php";
    //CREATE ACCOUNT
    public static final String URL_CREATE_ACCOUNT = "http://192.168.100.7/teamOneProject/register/create_employee.php";
    //LOGIN ACCOUNT
    public static final String URL_LOGIN = "http://192.168.100.7/teamOneProject/login/login.php";
    //GET PROBLEM
    public static final String URL_GET_PROBLEM = "http://192.168.100.7/teamOneProject/dashboard_emp/get_problem.php";
    //GET PROBLEM
    public static final String URL_CREATE_TICKET = "http://192.168.100.7/teamOneProject/dashboard_emp/create_ticket.php";
    //GET TICKET QUEUE
    public static final String URL_GET_TICKET_QUEUE = "http://192.168.100.7/teamOneProject/dashboard_emp/my_ticket_queue.php?email=";
    //GET TICKET ONGOING
    public static final String URL_GET_TICKET_ONGOING = "http://192.168.100.7/teamOneProject/dashboard_emp/my_ticket_ongoing.php?email=";
    //GET TICKET ONGOING
    public static final String URL_GET_TICKET_SOLVED = "http://192.168.100.7/teamOneProject/dashboard_emp/my_ticket_solved.php?email=";

    //DEVELOPER
    //GET TICKET ON GOING
    public static final String URL_GET_ALL_ON_GOING_TICKET_DEVELOPER = "http://192.168.0.100/teamOneProject/dashboard_dev_test/ongoing_ticket.php?id_solver=";
    public static final String URL_GET_DETAIL_ON_GOING_TICKET_DEVELOPER = "http://192.168.0.100/teamOneProject/dashboard_dev_test/ongoing_ticket_detail.php";
    public static final String URL_UPDATE_ON_GOING_TICKET_DETAIL_DEVELOPER = "http://192.168.0.100/teamOneProject/dashboard_dev_test/update_ongoing_ticket.php";

    //GET TICKET QUEUE
    public static final String URL_GET_ALL_QUEUE_TICKET_DEVELOPER = "http://192.168.0.100/teamOneProject/dashboard_dev_test/queue_ticket.php?id_division=";
    public static final String URL_GET_DETAIL_QUEUE_TICKET_DEVELOPER = "http://192.168.0.100/teamOneProject/dashboard_dev_test/queue_ticket_detail.php";
    public static final String URL_UPDATE_QUEUE_TICKET_DETAIL_DEVELOPER = "http://192.168.0.100/teamOneProject/dashboard_dev_test/update_ongoing_ticket.php";


    //KEY CREATE ACCOUNT
    public static final String KEY_NAMA_EMP = "nama_emp";
    public static final String KEY_ID_EMP = "id_emp";
    public static final String KEY_NAMA_EMAIL = "email";
    public static final String KEY_NAMA_ADDRESS = "address";
    public static final String KEY_NAMA_ID_BRANCH = "id_branch";
    public static final String KEY_NAMA_ID_DIVISION = "id_division";
    public static final String KEY_NAMA_BIRTHDATE = "birth_date";
    public static final String KEY_NAMA_JOB_TITLE = "job_title";
    public static final String KEY_NAMA_PASSWORD = "password";
    public static final String KEY_NAMA_PHONE = "phone";
    public static final String KEY_NAME_EMP = "name_emp";
    //KEY CREATE TICKET
    public static final String KEY_ID_PROBLEM = "id_problem";
    public static final String KEY_PROBLEM_NAME = "problem_name";
    public static final String KEY_CREATE_DATE = "create_date";
    public static final String KEY_PROBLEM_DETAIL = "problem_detail";
    //KEY GET TICKET
    public static final String KEY_TICKET_STATUS = "status";
    public static final String KEY_TICKET_ID = "id_ticket";
    public static final String KEY_TICKET_CREATED_DATE = "create_date";
    public static final String KEY_TICKET_ASSIGNED_DATE = "assign_date";
    public static final String KEY_TICKET_END_DATE = "end_date";

    //OTHER
    public static final String KEY_ID_SOLVER = "id_solver";
    public static final String KEY_TICKET_PROBLEM_NAME = "problem_name";
    public static final String KEY_TICKET_SOLVER_NAME = "name_emp";
    public static final String KEY_TICKET_PROBLEM_DETAIL = "problem_detail";

    //KEY UPDATE ONGOING TICKET
    public static final String KEY_NOTE_DEVELOPER = "dev_note";
    //key JSON
    public static final String KEY_DIVISION = "id_division";
    public static final String KEY_NAME_DIVISION = "name_division";
    public static final String KEY_BRANCH = "id_branch";
    public static final String KEY_NAME_BRANCH = "branch_name";

    //flag JSON
    public static final String TAG_JSON_ARRAY = "result";

    //VARIABLE
    public static final String DIV_ID = "id_division";
    public static final String BRANCH_ID = "id_branch";

//
//    public static final String TAG_JSON_ID_TICKET = "id_ticket";
//    public static final String TAG_JSON_CREATE_DATE = "create_date";
//    public static final String TAG_JSON_NAME_EMP = "name_emp";
//    public static final String TAG_JSON_PROBLEM_NAME = "problem_name";
//
//    public static final String TICKET_ID = "ticket_id";

    public static final String status_response_success = "success";
    public static final String status_response_failed = "failed";
    public static final String response_login_role = "role";
    public static final String response_login_access_token = "access_token";
    public static final String response_login_email = "email";
    public static final String response_login_role_developer = "Developer";
    public static final String response_login_role_employee = "Employee";
    public static final String response_login_name_emp = "name_emp";

    public static final String response_login_user_access_token = "access_token";
    public static final String response_login_user_role = "role";
    public static final String response_login_user_name = "name_emp";

    public static final String response_login_id_division = "id_division";

    public static final String TAG_JSON_ID_TICKET = "id_ticket_developer";
    public static final String TAG_JSON_ID_DIVISION = "id_division_developer";

    public static final String STATUS_SOLVED = "Solved";

}
