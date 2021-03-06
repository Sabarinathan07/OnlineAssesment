<?php 

	class DbOperations{

		private $con; 

		function __construct(){

			require_once dirname(__FILE__).'/DbConnect.php';

			$db = new DbConnect();

			$this->con = $db->connect();

		}
				
		public function createUser($username, $pass){
			if($this->isUserExist($username)){
				return 0; 
			}else{
				$password = md5($pass);
				$stmt = $this->con->prepare("INSERT INTO `teacher` (`id`, `username`, `password`) VALUES (NULL, ?, ?);");			
				//INSERT INTO `teacher` (`id`, `username`, `password`) VALUES ('2', 'sabari', 'sabar');
				$stmt->bind_param("ss",$username,$password);

				if($stmt->execute()){
					return 1; 
				}
				else{
					return 2; 
				}
			}
		}	

		private function isUserExist($username){
			$stmt = $this->con->prepare("SELECT id FROM teacher WHERE username = ? ");
			$stmt->bind_param("s", $username);
			$stmt->execute(); 
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}

	}
	?>