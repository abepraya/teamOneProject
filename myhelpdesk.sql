-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2022 at 07:32 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myhelpdesk`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id_account` int(11) NOT NULL,
  `id_emp` int(11) NOT NULL,
  `password` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id_account`, `id_emp`, `password`) VALUES
(1, 1, 0x243279243130246e374f722f2f7a7a6f536951746c5a4e346644522f4f447271717a354f534e38387644745250376e4b4134656e30644274554c4d53),
(2, 2, 0x2432792431302455325848472f6d706a48767a30647a792f386f653275364d71596977444557776e7655465a326969676e2f746b566744414b626771),
(3, 3, 0x24327924313024465a5054753262362e7575482e6c714970413545374f616a746b2f596a6d53372f47324d5a4c685068496c4c665a516f74364f6f32),
(4, 4, 0x24327924313024545a637275724b436a76554d7a4f72704951596f4b7558486676347050544b50446e4763714376573956545a7a48633241647a5461),
(5, 5, 0x243279243130242f305533436869567544587477654772426f41477965685a6b6b357263383046333746372f4b5452704a55447a326158542e2e6b57),
(6, 6, 0x24327924313024534d4a4b6a7738553955574d6b6f7a4a6e5a6643574f434f496f4f473639616d536c4f79676f54433373394a414a6269657a4e5836),
(7, 7, 0x2432792431302470435a2f6d545a645a51384c456a592f53544f62724f6841444776386d3731593549564867446f566d302f64744e446e464a705836),
(8, 8, 0x243279243130244f77627342477631584c42375466546469476b444e65325367462f32372f41397770566263413172675943733241383952372f2e61),
(9, 9, 0x243279243130244a6f4233416c4f32376b6f2e4b4675757253525439754e6268373641464b313375526a507766314148476d49713069454e45356f57),
(10, 10, 0x24327924313024576a58564b6f6e74456157686f3049376b69314b784f647a73307934434744614544553255647343745458772e4f5756625a374e53),
(11, 11, 0x24327924313024766d5041706f774954384e56515870656d5237524b756e3845433973337a6c72576b4949674359394f422f477063342e4c506e4b43),
(12, 12, 0x243279243130244f5a7466437577697353477054637569336a727565754649516c7775784b42544e4e3638674b67394e66317a53324f5430776e5171),
(13, 13, 0x2432792431302436557541315276304f6935615142517a2e424169634f4e2e6a7873336a796b4c4a3777413746353947487273576b77434554584a2e),
(14, 14, 0x24327924313024627a6b794148634e6978397846744d5852575644506576546f514b36557043744e67617661342e2e6a77346a55313061435361624b),
(15, 15, 0x243279243130247566714e6157566a4a474159737a482f69664e30754f44654433466c4f323531505671495563485170517671596c797a6762535375),
(16, 16, 0x24327924313024304e306777354573747a314c592e6e2f765a384b382e464277736961483845466e6a71634c6d57563579614473726344464a59342e),
(17, 17, 0x243279243130246b694d4e67764842616c6b68672f416145426766552e546c674a734c44706e63423930436c526b5a74616c3877764b765438464e4f),
(18, 18, 0x2432792431302478444341664e7742684c624f624f7a2e6a6d6e36302e77786e39775676626434694c572f4748374b42516172523534357579784153),
(19, 19, 0x24327924313024413645424976674b694e6a596e6a6f33706a6935372e433474696534315056664e36396a7a35497062494b7548427a383453513879),
(20, 20, 0x243279243130246967686d306f51716f665042794e5735614f4167356570312f5330764a6a5474516568326e4747396735687044453865714e46774f),
(21, 21, 0x24327924313024586c77366431783574647433314f44534d316964542e74344e4b59423038384b396f6a37446b786235344d376f4f7a6b4f74436675),
(22, 22, 0x24327924313024516d45693249326d584678326768747a42424d547875316b584e5a55547774524648765036586f4f44585a34527139386236595575),
(23, 23, 0x243279243130246a78744545346a744e2f32384537436844632f56552e3951584b7171714d67544a4f6839664c2e61526b5874586b75515a6f516d47),
(24, 24, 0x243279243130244a315638584c6250356867576b35676a6737654d6b757147303958595435686a3966464e54437633756a356a586e53767841723236),
(25, 25, 0x2432792431302437423839496b516c38392f536c657435744e6545544f7473643753535250486a52526b5976742e38674a61657a562e4e6476755143),
(26, 26, 0x243279243130246c51415a656b53766a597a6e755856765648766f79654868342f6756746f786a433558506c6678506b336f5a536251346172593443),
(27, 27, 0x243279243130243249724d5436704f746b392f482e6c325a36464e642e32306237634a726f642e765456524949386c51423557755837634864746157),
(28, 28, 0x2432792431302442516d754d703379614d476e323036454d493357372e676647516c6a3330486f556b47335a346e6b47693564687051305032316643),
(29, 29, 0x2432792431302457574f414366554162387032444353574835614b74656a7069504671354e52322e5a596946707a66336f7366674c3977596a457161),
(30, 30, 0x24327924313024734a3938625230446867522e363238467948614f492e714c674f787854764c6765657058464757714e5a6d79764b314653515a6a4f),
(31, 31, 0x2432792431302445362f736141706a516d574d4a4c71634a53786d76752f536d61474f515862576e4962616a5055477750617244706a37334b523132),
(32, 32, 0x243279243130246855776b534a4f796532455964447733573733562f4f5a6e2f37466231543978476170724e72594375313261326139384850625565),
(33, 33, 0x24327924313024615a775142547539364f6531666e75302e6f4f75596555692e786441354d6d2e42737a634e724a4967366e324e5079495a4b794879),
(34, 34, 0x24327924313024732e6853314f496a6b6a4250674c76322f46735342654b335272316556564554743063684b783974316e51435770466f34616b5469),
(35, 35, 0x243279243130244c5679524a563364357357652f645442486d515a746561584d4a737671506b382f5577362f774e2f45532e316c6231567a7a792e47),
(36, 36, 0x243279243130244b706d4a34315877302f7a624574783868566f68502e643267302e347a65526d752f716a635a6b47756c344b37396f765974727469),
(37, 37, 0x243279243130247958564e69704a7a576a52777a4f474644446f65676539576758505677704f41684c53684b4e637747356f6c506456394d7a506436),
(38, 38, 0x243279243130246333786c49543778414d5132524e2e4f5a7a47594c655a43477175796264516363384a344b447a463158556b56322f6f732e775153),
(39, 39, 0x24327924313024514f495a497a6b62306175526144646e765761436a753153426d717a50617141386b76753248336f744a545569677962696459684b),
(40, 40, 0x24327924313024786267344a556d50784e696e55376e4b6b6347356d2e38304477533975417779554775447a534f68684878527636372e7a444e5a4f),
(41, 41, 0x24327924313024427264777532314649343843494f734930423437714f78715330484c353735494b4e2e78326f3938567257727970524f7137387271),
(42, 42, 0x243279243130244e474b444b49765754432e79464a556c7368776c336557792e6e486e3868544278786f465963386c2f414d48644a4e692e56693565),
(43, 43, 0x243279243130246a684e674941665076424b4c366c6756736c316f4a4f3735676d62656c6f6c7a52466a646f612e6945756d59333131385152374436),
(44, 44, 0x24327924313024374e39485a306331544b31635875416e727767517875507043626767782e6d614b4e64772f342e435a2f304d33574d6f7836447747),
(45, 45, 0x243279243130244d4e72715274663777383277514a5257736969716e7544717665346e666a7a695268486c54346548427a797a63626f504e44574457),
(46, 46, 0x243279243130246273336d373265666750794132383171614148784575754b6f36363732672f5369676666586c566f306e376c31655a6e782e543153),
(47, 47, 0x243279243130244f39366f67464661434b4344522e7a56676359634a65664f6d33324a584d474b4c4b39514a2e624f5867792f736747507533395371),
(48, 48, 0x2432792431302432734c415134336e51483555354c74316c6f5979762e7255666e705a614463395332756a4a6e542f436c7169747a794d3036547a43),
(49, 49, 0x243279243130246f57645345326331504f75694d63766250415642314f4641657149552e67346558732e6a2f59753155733256334841724a33656647),
(50, 50, 0x243279243130246d492e6442706d74785a59532f5547383964393773756a53495757696e43556855314b773439736c4b4d494a6a4d2e4338666f314b),
(51, 51, 0x243279243130246541444a673043474e7642354633733571556c58764f514d30555475754c56484c726641436a536f79523679675134373241487575),
(52, 52, 0x243279243130244e443547736e44537270534b61524264422e6844304f6d633875397469425046567152316a7352376e594532745331354772326153),
(53, 53, 0x24327924313024765577495971615242642e415271394f6342544a742e65575a492f47554f6f2f31463754625656375155744c6d52516e5777724165),
(54, 54, 0x243279243130242f624b665333444b6f634a3569706e765351334759656534696f6c6a674a423667755342574a6a7937333134773272633335423765);

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `id_branch` int(11) NOT NULL,
  `branch_name` varchar(255) NOT NULL,
  `branch_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`id_branch`, `branch_name`, `branch_address`) VALUES
(1, 'KC Tangerang', 'Jl. Daan Mogot No. 33 Sukasari Tangerang 15111'),
(2, 'KC  Roxy Mas', 'Jl. Hasyim Ashari Blok B1 12 A, Jakarta'),
(3, 'KC Fatmawati', 'Jl. R.S. Fatmawati No. 28 Jakarta'),
(4, 'KC Cempaka Mas\r\n', 'Graha Cempaka Mas Jl. Letjend. Suprapto Blok A No. 1-2, Jakarta 10640'),
(5, 'KCP Sentral Senayan 3', 'Gedung Sentral Senayan 3, Ground Floor, Jl. Asia Afrika 8, Gelora Bung Karno, Senayan, Jakarta Pusat 10270'),
(6, 'KC Summitmas', 'Summitmas Tower II Jl. Jend. Sudirman Kav. 61, Jakarta'),
(7, 'KCP Daan Mogot', 'Jl. Daan Mogot Raya Km 1 No. 10, Rukun Tetangga No. 011, Rukun Warga 04, Kelurahan Jelambar, Kecamatan Grogol Petamburan, Jakarta Barat.'),
(8, 'KCP Daan Mogot Baru', 'Ruko Daan Mogot Baru, Blok LB 5 No.31-32, Jakarta Barat'),
(9, 'KC Bogor', 'Jl. Suryakencana No. 231 Bogor'),
(10, 'KCP Dewi Sartika', 'Jl. Dewi Sartika No.27 D,Bogor'),
(11, 'KCP Kota Wisata', 'Ruko Trafalgar Bl. H-2&H-3 Sentra Eropa, Perum. Kota Wisata Jl. Transyogi km 6, Cibubur, Bogor'),
(12, 'KCP Pajajaran', 'Komp. Pertokoan Jl. Pajajaran No. 20 (28 L), Bogor'),
(13, 'KCP Soleh Iskandar', 'Jl. K. H. Soleh Iskandar No 2Q, Komplek Ruko 24, Bogor'),
(14, 'KCP Puri Kencana', 'Komp Rukan Puri Niaga III, Jl. Puri Kencana Blok. M - 8 No. 1 JKL, Jakarta Barat 11610'),
(15, 'KC Jatinegara', 'Jl. Jatinegara Timur 59 Jakarta'),
(16, 'KC Bumi Serpong Damai', 'Ruko BSD Sektor 7 Jl Raya Serpong Blok RN No 56-57 Tangerang 15310'),
(17, 'KC Bekasi', 'Ruko Sentra Niaga Kalimalang, Jl. Jend. A. Yani Blok A-1 No. 1 & 8, Kelurahan Kayuringin, Bekasi'),
(18, 'KC MT. Haryono', 'Wisma Korindo Lt. 1, Jl. MT. Haryono Kav. 62 Jakarta'),
(19, 'KCP Balikpapan Baru', 'Jl. MT. Haryono, Komp. Balikpapan Baru Blok B2 No. 1 Balikpapan, Kel. Damai Baru, Kec. Balikpapan Selatan 76126'),
(20, 'KC Wisma Keiai', 'Wisma KEIAI Lt. Dasar, Jl. Jend. Sudirman Kav. 3-4, Jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `division`
--

CREATE TABLE `division` (
  `id_division` int(11) NOT NULL,
  `name_division` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `division`
--

INSERT INTO `division` (`id_division`, `name_division`, `role`) VALUES
(1, 'IT Support', 'Developer'),
(2, 'Corporate Secretary ', 'Employee'),
(3, 'Operational Risk and Business Continuity', 'Employee'),
(4, 'Operations', 'Employee'),
(5, 'Human Capital', 'Employee'),
(6, 'Finance & Accounting', 'Employee'),
(7, 'Business Monitoring & QA', 'Employee'),
(8, 'Global Banking', 'Employee'),
(9, 'Marketing', 'Employee'),
(10, 'IT Application Development', 'Developer'),
(11, 'Cyber Security', 'Developer'),
(12, 'IT Network Architecture', 'Developer'),
(13, 'Database', 'Developer'),
(14, 'General Legal Consult', 'Employee'),
(15, 'Litigation', 'Employee'),
(16, 'Credit Review Management', 'Employee'),
(17, 'Procurement, Premises & Vendor Relation', 'Employee'),
(18, 'Asset Quality Management', 'Employee'),
(19, 'Business Planning & Analytics', 'Employee'),
(20, 'Business Process & Approval', 'Employee');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id_emp` int(11) NOT NULL,
  `name_emp` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `id_branch` int(11) NOT NULL,
  `id_division` int(11) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `birth_date` date NOT NULL,
  `job_title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id_emp`, `name_emp`, `email`, `address`, `id_branch`, `id_division`, `phone`, `birth_date`, `job_title`) VALUES
(1, 'Cesare Dawson', 'cesare@maybank.com', '901 Browning Terrace', 20, 16, '08898124805', '1985-07-20', 'Account Receivable Officer'),
(2, 'Nanice Corneille', 'nanice@maybank.com', '23 Sachs Trail', 3, 5, '08928276345', '1991-03-16', 'HC Employee Relations & Health Safety'),
(3, 'Gail Peagrim', 'gail@maybank.com', '99457 Scott Street', 1, 2, '08352595013', '1994-08-18', 'Corporate Secretarial Executive'),
(4, 'Shelden Allbones', 'shelden@maybank.com', '8257 Hoepker Hill', 14, 16, '08759392143', '1992-11-14', 'Credit Analyst'),
(5, 'Delora Achrameev', 'delora@maybank.com', '27099 Pearson Pass', 12, 14, '08628676936', '1971-04-14', 'Legal Compliance Officer'),
(6, 'Ingemar McGurgan', 'ingemar@maybank.com', '3 Golf Course Plaza', 15, 14, '08767222027', '1993-10-24', 'Legal Compliance Officer'),
(7, 'Silas D\'Elias', 'silas@maybank.com', '4 Burrows Hill', 11, 14, '08759929104', '1977-08-14', 'Legal Compliance Officer'),
(8, 'Northrup Gouch', 'northrup@maybank.com', '92664 Maywood Way', 17, 17, '08890775794', '1970-06-10', 'General Procurement Specialist'),
(9, 'Marillin Stennes', 'marillin@maybank.com', '977 Nevada Road', 8, 19, '08628663855', '1994-09-13', 'Financial Planning and Business Analyst'),
(10, 'Henriette Deares', 'henriette@maybank.com', '816 Chinook Plaza', 18, 17, '08620661803', '1985-01-19', 'Vendor Relation Executive'),
(11, 'Merissa Rowsel', 'merissa@maybank.com', '041 Northport Place', 20, 14, '08687635605', '1990-01-13', 'Legal Compliance Officer'),
(12, 'Brion Lumsdon', 'brion@maybank.com', '36 Vidon Hill', 16, 18, '08632868227', '1996-05-10', 'Asset Analyst'),
(13, 'Gregorio Charrington', 'gregorio@maybank.com', '2 Mockingbird Circle', 9, 15, '08139917141', '1974-11-12', 'Litigation & Recovery Asset Officer'),
(14, 'Joey Lindeman', 'joey@maybank.com', '802 Village Way', 18, 20, '08722217762', '1995-05-11', 'Business Process & Data Analyst Supervisor'),
(15, 'Amalia Beldom', 'amalia@maybank.com', '7375 Dennis Junction', 16, 20, '08877166298', '1990-07-02', 'Business Process Officer'),
(16, 'Steffen Geale', 'steffen@maybank.com', '4738 Lillian Point', 18, 19, '08379865778', '1971-07-09', 'Financial Planning and Business Analyst'),
(17, 'Adam Matic', 'adam@maybank.com', '8 Tony Junction', 2, 1, '08708939575', '1995-07-30', 'TIE TKO Branch'),
(18, 'Obediah Willicott', 'obediah@maybank.com', '11314 Tomscot Alley', 13, 15, '08739140156', '1990-06-18', 'Litigation & Recovery Asset Officer'),
(19, 'Dian Swanson', 'dian@maybank.com', '953 Emmet Point', 13, 19, '08474239146', '1988-08-14', 'Financial Planning and Business Analyst'),
(20, 'Tynan Coping', 'tynan@maybank.com', '0 Homewood Pass', 11, 16, '08419552706', '1988-09-12', 'Credit Analyst'),
(21, 'Romona Danat', 'romona@maybank.com', '696 Kings Road', 3, 2, '08832159000', '1970-08-15', 'Corporate Secretary Assistant Manager'),
(22, 'Candide Doiley', 'candide@maybank.com', '91437 4th Way', 15, 15, '08370988034', '1990-05-12', 'Litigation Specialist'),
(23, 'Elmer Stanbrooke', 'elmer@maybank.com', '48 Holy Cross Court', 11, 20, '08982735175', '1980-01-22', 'Business Process Officer'),
(24, 'Arlene Shimmings', 'arlene@maybank.com', '67835 Dawn Crossing', 17, 14, '08347883289', '1994-07-12', 'Legal Compliance Officer'),
(25, 'Tyler Bate', 'tyler@maybank.com', '089 Barnett Junction', 7, 16, '08802501152', '1988-03-17', 'Account Receivable Officer'),
(26, 'Nanni Winterton', 'nanni@maybank.com', '53 Graceland Crossing', 12, 20, '08858528396', '1991-04-11', 'Junior Officer Business Process & Quality Management'),
(27, 'Bess Bearns', 'bess@maybank.com', '923 Debra Circle', 3, 3, '08166552067', '1992-06-11', 'Risk & KYC Manager'),
(28, 'Lilly Melbourne', 'lilly@maybank.com', '2636 Village Green Circle', 19, 16, '08565525993', '1971-12-09', 'Account Receivable Officer'),
(29, 'Hyacinth McMorran', 'hyacinth@maybank.com', '9354 Butterfield Junction', 18, 14, '08106920045', '1979-03-21', 'Legal Satff'),
(30, 'Colene Gerardin', 'colene@maybank.com', '5 West Park', 8, 16, '08570660245', '1974-07-31', 'Credit Analyst'),
(31, 'Sibelle Kosel', 'sibelle@maybank.com', '9320 Memorial Park', 1, 4, '08901621321', '1990-02-06', 'SM Operations'),
(32, 'Libby Brafield', 'libby@maybank.com', '85 Banding Point', 15, 16, '08125907935', '1989-08-17', 'Credit Analyst'),
(33, 'Gloriana Burnsell', 'gloriana@maybank.com', '145 Lukken Terrace', 12, 20, '08913774437', '1991-03-07', 'Business Process Officer'),
(34, 'Maureen Jost', 'maureen@maybank.com', '6087 Warrior Parkway', 19, 16, '08928335143', '1972-08-14', 'Account Receivable Officer'),
(35, 'Chicky Pasterfield', 'chicky@maybank.com', '7 Bluestem Crossing', 20, 17, '08593932562', '1973-12-11', 'General Procurement Specialist'),
(36, 'Ashton St Leger', 'ashton@maybank.com', '4 Hazelcrest Lane', 12, 18, '08146106672', '1972-05-23', 'Asset Reviewer'),
(37, 'Nicole Nowakowski', 'nicole@maybank.com', '13 Towne Drive', 20, 18, '08389513596', '1996-08-30', 'Asset Quality Control Officer'),
(38, 'Marlane Valentetti', 'marlane@maybank.com', '31 Starling Drive', 2, 9, '08641191645', '1992-02-12', 'Marketing Lending Officer'),
(39, 'Cris Blacksland', 'cris@maybank.com', '74035 Schiller Trail', 15, 16, '08312664328', '1986-04-08', 'Credit Policy Head'),
(40, 'Giordano Gelly', 'giordano@maybank.com', '65026 Meadow Valley Junction', 4, 9, '08764937340', '1987-05-17', 'Marketing Lending Officer'),
(41, 'Josh Bridie', 'josh@maybank.com', '04402 Nobel Circle', 9, 20, '08609883851', '1990-12-21', 'Business Process Officer'),
(42, 'Baily Fogarty', 'baily@maybank.com', '6 Oriole Place', 17, 15, '08437955678', '1973-01-14', 'Litigation Specialist'),
(43, 'Sabrina Bidmead', 'sabrina@maybank.com', '5 Holy Cross Pass', 9, 19, '08206504830', '1993-02-24', 'Financial Planning and Business Analyst'),
(44, 'Rhiamon Colbeck', 'rhiamon@maybank.com', '78071 Warbler Parkway', 13, 20, '08958514776', '1972-03-13', 'Business Process & Data Analyst Supervisor'),
(45, 'Aretha De Moreno', 'aretha@maybank.com', '21 Jenna Crossing', 18, 18, '08861269386', '1992-05-11', 'Asset Reviewer'),
(46, 'Gayla Connealy', 'gayla@maybank.com', '594 Kim Drive', 15, 15, '08253189668', '1979-02-14', 'Legal & Insurance Manager'),
(47, 'Wit Liddard', 'wit@maybank.com', '80 Montana Point', 15, 14, '08554715922', '1993-01-02', 'Legal Satff'),
(48, 'Chick Wratten', 'chick@maybank.com', '331 3rd Alley', 8, 14, '08496352306', '1989-12-21', 'Legal Satff'),
(49, 'Lionello Hawes', 'lionello@maybank.com', '67090 Prairie Rose Pass', 1, 4, '08650500063', '1979-05-12', 'Teller'),
(50, 'Dehlia Swalough', 'dehlia@maybank.com', '169 Raven Road', 10, 16, '08617933205', '1972-08-25', 'Credit Policy Head'),
(51, 'Andree Gabala', 'andree@maybank.com', '23 Rigney Circle', 5, 10, '08191257128', '1993-08-10', 'Backend Programmer'),
(52, 'Mannie Casement', 'mannie@maybank.com', '7 Tennessee Circle', 5, 11, '08906602152', '1977-09-15', 'IT Security Staff'),
(53, 'Christy Hassen', 'christy@maybank.com', '094 Harper Avenue', 5, 12, '08589838261', '1992-02-01', 'Network Engineer Supervisor'),
(54, 'Brad Haldene', 'brad@maybank.com', '322 Russell Road', 5, 13, '08271614323', '1982-08-29', 'Database Admininstrator');

-- --------------------------------------------------------

--
-- Table structure for table `problem`
--

CREATE TABLE `problem` (
  `id_problem` int(11) NOT NULL,
  `problem_name` varchar(255) NOT NULL,
  `id_division` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `problem`
--

INSERT INTO `problem` (`id_problem`, `problem_name`, `id_division`) VALUES
(1, 'Error Aplikasi Compliance Monitoring', 10),
(2, 'Error Aplikasi DCIF', 10),
(3, 'Error Aplikasi MyHR', 10),
(4, 'Error Aplikasi My Finance Info  ', 10),
(5, 'Error Aplikasi DTeller', 10),
(6, 'Komputer Error', 1),
(7, 'Error Restore Back Up', 1),
(8, 'Update Sistem Operasi Gagal', 1),
(9, 'Hardware Pendukung Tidak Berfungsi', 1),
(10, 'Serangan Virus Komputer', 11),
(11, 'Jaringan Komputer Terputus dari Server', 12),
(12, 'Pengkinian Data Tidak Tersimpan', 13),
(13, 'Kesalahan Input Data', 13),
(14, 'Jaringan Lambat', 12),
(15, 'User Terblokir & Lupa Password', 13);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id_ticket` int(11) NOT NULL,
  `id_emp` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `id_problem` int(11) NOT NULL,
  `problem_detail` varchar(255) NOT NULL,
  `assign_date` date NOT NULL,
  `end_date` date NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `id_solver` int(11) DEFAULT NULL,
  `dev_note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`id_ticket`, `id_emp`, `create_date`, `id_problem`, `problem_detail`, `assign_date`, `end_date`, `status`, `id_solver`, `dev_note`) VALUES
(1, 1, '2022-02-06', 1, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Bug Login'),
(2, 2, '2022-02-06', 2, 'Aplikasi Logout ketika menu setting ditekan', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Button logout yang berdekatan dengan setting'),
(3, 3, '2022-02-06', 3, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Bug Login'),
(4, 4, '2022-02-06', 4, 'Aplikasi ubah password tidak dapat ditekan', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Button ubah password'),
(5, 5, '2022-02-06', 5, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-07', '2022-02-08', 'Solved', 51, 'Mamperbaiki bug Login'),
(6, 6, '2022-02-06', 6, 'Komputer mengalami blank screen dan tidak merespon', '2022-02-07', '2022-02-08', 'Solved', 17, 'Restart Komputer dengan mencabut power supply'),
(7, 7, '2022-02-06', 7, 'Gagal melakukan restore data back up ketika restart komputer', '2022-02-07', '2022-02-08', 'Solved', 17, 'Membuka locked data terlebih dahulu'),
(8, 8, '2022-02-07', 8, 'Sistem operasi update gagal dan tidak hanya menampilkan booting', '2022-02-08', '2022-02-09', 'Solved', 17, 'Melakukan instal ulang sistem operasi komputer lalu melakukan restore'),
(9, 9, '2022-02-07', 9, 'Keyboard Laptop tidak berfungsi', '2022-02-08', '2022-02-09', 'Solved', 17, 'Mengganti Keyboard laptop dengan baru karena connector sudah rusak'),
(10, 10, '2022-02-07', 10, 'Monitor komputer muncul pop up tebusan ransomeware', '2022-02-08', '2022-02-09', 'Solved', 52, 'Putuskan koneksi jaringan'),
(11, 11, '2022-02-07', 10, 'Muncul pop up pengiriman data tetapi tidak merespon ketika di close', '2022-02-08', '2022-02-09', 'Solved', 52, 'Putuskan koneksi jaringan'),
(12, 12, '2022-02-07', 11, 'Jaringan Internet masih terhunbung tetapi tertulis di aplikasi terputus dari server', '2022-02-08', '2022-02-09', 'Solved', 53, 'Memperbaiki API dan koneksi server'),
(13, 13, '2022-02-07', 12, 'Ketika melakukan submit sistem dan di cek kembali data tidak muncul', '2022-02-08', '2022-02-09', 'Solved', 54, 'Memperbaiki bug database'),
(14, 14, '2022-02-07', 13, 'Salah input nama lengkap nasabah ke dalam sistem', '2022-02-08', '2022-02-09', 'Solved', 54, 'Mengedit data melalui sistem database'),
(15, 15, '2022-02-08', 14, 'Jaringan Lambat ketika melakukan submit data hanya muncul loading', '2022-02-09', '2022-02-10', 'Solved', 53, 'Melakukan mainteinance server '),
(16, 16, '2022-02-08', 15, 'Lupa password untuk melakukan akses ke aplikasi', '2022-02-09', '2022-02-10', 'Solved', 54, 'Mereset password melalui sistem database'),
(17, 1, '2022-02-09', 1, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(18, 2, '2022-02-09', 2, 'Aplikasi Logout ketika menu setting ditekan', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(19, 3, '2022-02-09', 3, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(20, 4, '2022-02-09', 4, 'Aplikasi ubah password tidak dapat ditekan', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(21, 5, '2022-02-09', 5, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(22, 6, '2022-02-09', 6, 'Komputer mengalami blank screen dan tidak merespon', '2022-02-10', '0000-00-00', 'Assigned', 17, NULL),
(23, 7, '2022-02-09', 7, 'Gagal melakukan restore data back up ketika restart komputer', '2022-02-10', '0000-00-00', 'Assigned', 17, NULL),
(24, 8, '2022-02-10', 8, 'Sistem operasi update gagal dan tidak hanya menampilkan booting', '2022-02-11', '0000-00-00', 'Assigned', 17, NULL),
(25, 9, '2022-02-10', 9, 'Keyboard Laptop tidak berfungsi', '2022-02-11', '0000-00-00', 'Assigned', 17, NULL),
(26, 10, '2022-02-10', 10, 'Monitor komputer muncul pop up tebusan ransomeware', '2022-02-11', '0000-00-00', 'Assigned', 52, NULL),
(27, 11, '2022-02-10', 10, 'Muncul pop up pengiriman data tetapi tidak merespon ketika di close', '2022-02-11', '0000-00-00', 'Assigned', 52, NULL),
(28, 12, '2022-02-10', 11, 'Jaringan Internet masih terhunbung tetapi tertulis di aplikasi terputus dari server', '2022-02-11', '0000-00-00', 'Assigned', 53, NULL),
(29, 13, '2022-02-10', 12, 'Ketika melakukan submit sistem dan di cek kembali data tidak muncul', '2022-02-11', '0000-00-00', 'Assigned', 54, NULL),
(30, 14, '2022-02-10', 13, 'Salah input nama lengkap nasabah ke dalam sistem', '2022-02-11', '0000-00-00', 'Assigned', 54, NULL),
(31, 15, '2022-02-11', 14, 'Jaringan Lambat ketika melakukan submit data hanya muncul loading', '2022-02-12', '0000-00-00', 'Assigned', 53, NULL),
(32, 16, '2022-02-11', 15, 'Lupa password untuk melakukan akses ke aplikasi', '2022-02-12', '0000-00-00', 'Assigned', 54, NULL),
(33, 1, '2022-02-18', 1, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(34, 2, '2022-02-18', 2, 'Aplikasi Logout ketika menu setting ditekan', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(35, 3, '2022-02-18', 3, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(36, 4, '2022-02-18', 4, 'Aplikasi ubah password tidak dapat ditekan', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(37, 5, '2022-02-18', 5, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(38, 6, '2022-02-17', 6, 'Komputer mengalami blank screen dan tidak merespon', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(39, 7, '2022-02-17', 7, 'Gagal melakukan restore data back up ketika restart komputer', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(40, 8, '2022-02-17', 8, 'Sistem operasi update gagal dan tidak hanya menampilkan booting', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(41, 9, '2022-02-17', 9, 'Keyboard Laptop tidak berfungsi', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(42, 10, '2022-02-17', 10, 'Monitor komputer muncul pop up tebusan ransomeware', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(43, 11, '2022-02-19', 10, 'Muncul pop up pengiriman data tetapi tidak merespon ketika di close', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(44, 12, '2022-02-19', 11, 'Jaringan Internet masih terhunbung tetapi tertulis di aplikasi terputus dari server', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(45, 13, '2022-02-19', 12, 'Ketika melakukan submit sistem dan di cek kembali data tidak muncul', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(46, 14, '2022-02-19', 13, 'Salah input nama lengkap nasabah ke dalam sistem', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(47, 15, '2022-02-19', 14, 'Jaringan Lambat ketika melakukan submit data hanya muncul loading', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(48, 16, '2022-02-19', 15, 'Lupa password untuk melakukan akses ke aplikasi', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(49, 16, '2022-02-06', 1, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Bug Login'),
(50, 1, '2022-02-06', 2, 'Aplikasi Logout ketika menu setting ditekan', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Button logout yang berdekatan dengan setting'),
(51, 2, '2022-02-06', 3, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Bug Login'),
(52, 3, '2022-02-06', 4, 'Aplikasi ubah password tidak dapat ditekan', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Button ubah password'),
(53, 4, '2022-02-06', 5, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-07', '2022-02-08', 'Solved', 51, 'Mamperbaiki bug Login'),
(54, 5, '2022-02-06', 6, 'Komputer mengalami blank screen dan tidak merespon', '2022-02-07', '2022-02-08', 'Solved', 17, 'Restart Komputer dengan mencabut power supply'),
(55, 6, '2022-02-06', 7, 'Gagal melakukan restore data back up ketika restart komputer', '2022-02-07', '2022-02-08', 'Solved', 17, 'Membuka locked data terlebih dahulu'),
(56, 7, '2022-02-07', 8, 'Sistem operasi update gagal dan tidak hanya menampilkan booting', '2022-02-08', '2022-02-09', 'Solved', 17, 'Melakukan instal ulang sistem operasi komputer lalu melakukan restore'),
(57, 8, '2022-02-07', 9, 'Keyboard Laptop tidak berfungsi', '2022-02-08', '2022-02-09', 'Solved', 17, 'Mengganti Keyboard laptop dengan baru karena connector sudah rusak'),
(58, 9, '2022-02-07', 10, 'Monitor komputer muncul pop up tebusan ransomeware', '2022-02-08', '2022-02-09', 'Solved', 52, 'Putuskan koneksi jaringan'),
(59, 10, '2022-02-07', 10, 'Muncul pop up pengiriman data tetapi tidak merespon ketika di close', '2022-02-08', '2022-02-09', 'Solved', 52, 'Putuskan koneksi jaringan'),
(60, 11, '2022-02-07', 11, 'Jaringan Internet masih terhunbung tetapi tertulis di aplikasi terputus dari server', '2022-02-08', '2022-02-09', 'Solved', 53, 'Memperbaiki API dan koneksi server'),
(61, 12, '2022-02-07', 12, 'Ketika melakukan submit sistem dan di cek kembali data tidak muncul', '2022-02-08', '2022-02-09', 'Solved', 54, 'Memperbaiki bug database'),
(62, 13, '2022-02-07', 13, 'Salah input nama lengkap nasabah ke dalam sistem', '2022-02-08', '2022-02-09', 'Solved', 54, 'Mengedit data melalui sistem database'),
(63, 14, '2022-02-08', 14, 'Jaringan Lambat ketika melakukan submit data hanya muncul loading', '2022-02-09', '2022-02-10', 'Solved', 53, 'Melakukan mainteinance server '),
(64, 15, '2022-02-08', 15, 'Lupa password untuk melakukan akses ke aplikasi', '2022-02-09', '2022-02-10', 'Solved', 54, 'Mereset password melalui sistem database'),
(65, 16, '2022-02-09', 1, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(66, 1, '2022-02-09', 2, 'Aplikasi Logout ketika menu setting ditekan', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(67, 2, '2022-02-09', 3, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(68, 3, '2022-02-09', 4, 'Aplikasi ubah password tidak dapat ditekan', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(69, 4, '2022-02-09', 5, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(70, 5, '2022-02-09', 6, 'Komputer mengalami blank screen dan tidak merespon', '2022-02-10', '0000-00-00', 'Assigned', 17, NULL),
(71, 6, '2022-02-09', 7, 'Gagal melakukan restore data back up ketika restart komputer', '2022-02-10', '0000-00-00', 'Assigned', 17, NULL),
(72, 7, '2022-02-10', 8, 'Sistem operasi update gagal dan tidak hanya menampilkan booting', '2022-02-11', '0000-00-00', 'Assigned', 17, NULL),
(73, 8, '2022-02-10', 9, 'Keyboard Laptop tidak berfungsi', '2022-02-11', '0000-00-00', 'Assigned', 17, NULL),
(74, 9, '2022-02-10', 10, 'Monitor komputer muncul pop up tebusan ransomeware', '2022-02-11', '0000-00-00', 'Assigned', 52, NULL),
(75, 10, '2022-02-10', 10, 'Muncul pop up pengiriman data tetapi tidak merespon ketika di close', '2022-02-11', '0000-00-00', 'Assigned', 52, NULL),
(76, 11, '2022-02-10', 11, 'Jaringan Internet masih terhunbung tetapi tertulis di aplikasi terputus dari server', '2022-02-11', '0000-00-00', 'Assigned', 53, NULL),
(77, 12, '2022-02-10', 12, 'Ketika melakukan submit sistem dan di cek kembali data tidak muncul', '2022-02-11', '0000-00-00', 'Assigned', 54, NULL),
(78, 13, '2022-02-10', 13, 'Salah input nama lengkap nasabah ke dalam sistem', '2022-02-11', '0000-00-00', 'Assigned', 54, NULL),
(79, 14, '2022-02-11', 14, 'Jaringan Lambat ketika melakukan submit data hanya muncul loading', '2022-02-12', '0000-00-00', 'Assigned', 53, NULL),
(80, 15, '2022-02-11', 15, 'Lupa password untuk melakukan akses ke aplikasi', '2022-02-12', '0000-00-00', 'Assigned', 54, NULL),
(81, 16, '2022-02-18', 1, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(82, 1, '2022-02-18', 2, 'Aplikasi Logout ketika menu setting ditekan', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(83, 2, '2022-02-18', 3, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(84, 3, '2022-02-18', 4, 'Aplikasi ubah password tidak dapat ditekan', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(85, 4, '2022-02-18', 5, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(86, 5, '2022-02-17', 6, 'Komputer mengalami blank screen dan tidak merespon', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(87, 6, '2022-02-17', 7, 'Gagal melakukan restore data back up ketika restart komputer', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(88, 7, '2022-02-17', 8, 'Sistem operasi update gagal dan tidak hanya menampilkan booting', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(89, 8, '2022-02-17', 9, 'Keyboard Laptop tidak berfungsi', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(90, 9, '2022-02-17', 10, 'Monitor komputer muncul pop up tebusan ransomeware', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(91, 10, '2022-02-19', 10, 'Muncul pop up pengiriman data tetapi tidak merespon ketika di close', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(92, 11, '2022-02-19', 11, 'Jaringan Internet masih terhunbung tetapi tertulis di aplikasi terputus dari server', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(93, 12, '2022-02-19', 12, 'Ketika melakukan submit sistem dan di cek kembali data tidak muncul', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(94, 13, '2022-02-19', 13, 'Salah input nama lengkap nasabah ke dalam sistem', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(95, 14, '2022-02-19', 14, 'Jaringan Lambat ketika melakukan submit data hanya muncul loading', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(96, 15, '2022-02-19', 15, 'Lupa password untuk melakukan akses ke aplikasi', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(97, 3, '2022-02-06', 1, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Bug Login'),
(98, 4, '2022-02-06', 2, 'Aplikasi Logout ketika menu setting ditekan', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Button logout yang berdekatan dengan setting'),
(99, 5, '2022-02-06', 3, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Bug Login'),
(100, 6, '2022-02-06', 4, 'Aplikasi ubah password tidak dapat ditekan', '2022-02-07', '2022-02-08', 'Solved', 51, 'Memperbaiki Button ubah password'),
(101, 7, '2022-02-06', 5, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-07', '2022-02-08', 'Solved', 51, 'Mamperbaiki bug Login'),
(102, 8, '2022-02-06', 6, 'Komputer mengalami blank screen dan tidak merespon', '2022-02-07', '2022-02-08', 'Solved', 17, 'Restart Komputer dengan mencabut power supply'),
(103, 9, '2022-02-06', 7, 'Gagal melakukan restore data back up ketika restart komputer', '2022-02-07', '2022-02-08', 'Solved', 17, 'Membuka locked data terlebih dahulu'),
(104, 10, '2022-02-07', 8, 'Sistem operasi update gagal dan tidak hanya menampilkan booting', '2022-02-08', '2022-02-09', 'Solved', 17, 'Melakukan instal ulang sistem operasi komputer lalu melakukan restore'),
(105, 11, '2022-02-07', 9, 'Keyboard Laptop tidak berfungsi', '2022-02-08', '2022-02-09', 'Solved', 17, 'Mengganti Keyboard laptop dengan baru karena connector sudah rusak'),
(106, 12, '2022-02-07', 10, 'Monitor komputer muncul pop up tebusan ransomeware', '2022-02-08', '2022-02-09', 'Solved', 52, 'Putuskan koneksi jaringan'),
(107, 13, '2022-02-07', 10, 'Muncul pop up pengiriman data tetapi tidak merespon ketika di close', '2022-02-08', '2022-02-09', 'Solved', 52, 'Putuskan koneksi jaringan'),
(108, 14, '2022-02-07', 11, 'Jaringan Internet masih terhunbung tetapi tertulis di aplikasi terputus dari server', '2022-02-08', '2022-02-09', 'Solved', 53, 'Memperbaiki API dan koneksi server'),
(109, 15, '2022-02-07', 12, 'Ketika melakukan submit sistem dan di cek kembali data tidak muncul', '2022-02-08', '2022-02-09', 'Solved', 54, 'Memperbaiki bug database'),
(110, 16, '2022-02-07', 13, 'Salah input nama lengkap nasabah ke dalam sistem', '2022-02-08', '2022-02-09', 'Solved', 54, 'Mengedit data melalui sistem database'),
(111, 1, '2022-02-08', 14, 'Jaringan Lambat ketika melakukan submit data hanya muncul loading', '2022-02-09', '2022-02-10', 'Solved', 53, 'Melakukan mainteinance server '),
(112, 2, '2022-02-08', 15, 'Lupa password untuk melakukan akses ke aplikasi', '2022-02-09', '2022-02-10', 'Solved', 54, 'Mereset password melalui sistem database'),
(113, 3, '2022-02-09', 1, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(114, 4, '2022-02-09', 2, 'Aplikasi Logout ketika menu setting ditekan', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(115, 5, '2022-02-09', 3, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(116, 6, '2022-02-09', 4, 'Aplikasi ubah password tidak dapat ditekan', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(117, 7, '2022-02-09', 5, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '2022-02-10', '0000-00-00', 'Assigned', 51, NULL),
(118, 8, '2022-02-09', 6, 'Komputer mengalami blank screen dan tidak merespon', '2022-02-10', '0000-00-00', 'Assigned', 17, NULL),
(119, 9, '2022-02-09', 7, 'Gagal melakukan restore data back up ketika restart komputer', '2022-02-10', '0000-00-00', 'Assigned', 17, NULL),
(120, 10, '2022-02-10', 8, 'Sistem operasi update gagal dan tidak hanya menampilkan booting', '2022-02-11', '0000-00-00', 'Assigned', 17, NULL),
(121, 11, '2022-02-10', 9, 'Keyboard Laptop tidak berfungsi', '2022-02-11', '0000-00-00', 'Assigned', 17, NULL),
(122, 12, '2022-02-10', 10, 'Monitor komputer muncul pop up tebusan ransomeware', '2022-02-11', '0000-00-00', 'Assigned', 52, NULL),
(123, 13, '2022-02-10', 10, 'Muncul pop up pengiriman data tetapi tidak merespon ketika di close', '2022-02-11', '0000-00-00', 'Assigned', 52, NULL),
(124, 14, '2022-02-10', 11, 'Jaringan Internet masih terhunbung tetapi tertulis di aplikasi terputus dari server', '2022-02-11', '0000-00-00', 'Assigned', 53, NULL),
(125, 15, '2022-02-10', 12, 'Ketika melakukan submit sistem dan di cek kembali data tidak muncul', '2022-02-11', '0000-00-00', 'Assigned', 54, NULL),
(126, 16, '2022-02-10', 13, 'Salah input nama lengkap nasabah ke dalam sistem', '2022-02-11', '0000-00-00', 'Assigned', 54, NULL),
(127, 1, '2022-02-11', 14, 'Jaringan Lambat ketika melakukan submit data hanya muncul loading', '2022-02-12', '0000-00-00', 'Assigned', 53, NULL),
(128, 2, '2022-02-11', 15, 'Lupa password untuk melakukan akses ke aplikasi', '2022-02-12', '0000-00-00', 'Assigned', 54, NULL),
(129, 3, '2022-02-18', 1, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(130, 4, '2022-02-18', 2, 'Aplikasi Logout ketika menu setting ditekan', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(131, 5, '2022-02-18', 3, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(132, 6, '2022-02-18', 4, 'Aplikasi ubah password tidak dapat ditekan', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(133, 7, '2022-02-18', 5, 'Aplikasi Terhenti Setiap Kali Melakukan Login', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(134, 8, '2022-02-17', 6, 'Komputer mengalami blank screen dan tidak merespon', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(135, 9, '2022-02-17', 7, 'Gagal melakukan restore data back up ketika restart komputer', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(136, 10, '2022-02-17', 8, 'Sistem operasi update gagal dan tidak hanya menampilkan booting', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(137, 11, '2022-02-17', 9, 'Keyboard Laptop tidak berfungsi', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(138, 12, '2022-02-17', 10, 'Monitor komputer muncul pop up tebusan ransomeware', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(139, 13, '2022-02-19', 10, 'Muncul pop up pengiriman data tetapi tidak merespon ketika di close', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(140, 14, '2022-02-19', 11, 'Jaringan Internet masih terhunbung tetapi tertulis di aplikasi terputus dari server', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(141, 15, '2022-02-19', 12, 'Ketika melakukan submit sistem dan di cek kembali data tidak muncul', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(142, 16, '2022-02-19', 13, 'Salah input nama lengkap nasabah ke dalam sistem', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(143, 1, '2022-02-19', 14, 'Jaringan Lambat ketika melakukan submit data hanya muncul loading', '0000-00-00', '0000-00-00', 'Created', NULL, NULL),
(144, 2, '2022-02-19', 15, 'Lupa password untuk melakukan akses ke aplikasi', '0000-00-00', '0000-00-00', 'Created', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_account`),
  ADD KEY `id_emp` (`id_emp`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`id_branch`);

--
-- Indexes for table `division`
--
ALTER TABLE `division`
  ADD PRIMARY KEY (`id_division`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id_emp`),
  ADD KEY `id_branch` (`id_branch`),
  ADD KEY `id_job` (`id_division`);

--
-- Indexes for table `problem`
--
ALTER TABLE `problem`
  ADD PRIMARY KEY (`id_problem`),
  ADD KEY `job_id` (`id_division`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `id_emp` (`id_emp`),
  ADD KEY `id_problem` (`id_problem`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id_account` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `id_branch` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `division`
--
ALTER TABLE `division`
  MODIFY `id_division` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id_emp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `problem`
--
ALTER TABLE `problem`
  MODIFY `id_problem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id_ticket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=145;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`id_emp`) REFERENCES `employee` (`id_emp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`id_division`) REFERENCES `division` (`id_division`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`id_branch`) REFERENCES `branch` (`id_branch`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `problem`
--
ALTER TABLE `problem`
  ADD CONSTRAINT `problem_ibfk_1` FOREIGN KEY (`id_division`) REFERENCES `division` (`id_division`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_problem`) REFERENCES `problem` (`id_problem`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`id_emp`) REFERENCES `employee` (`id_emp`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
