/**  js-day6 
 *   유효성 검증 통과할 때만 `success.html` url로 이동합니다.
	1) 이름,이메일은 반드시 입력해야 함.
	2) 패스워드는 4글자 이상이어야 함.
	3) 나이는 15~99 사이 값.
 */

/*
    let regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	let regPassword =/^[a-zA-Z\\d`~!@#$%^&*()-_=+]{8,24}$/

function func_join() {
    const frm = document.forms[0]
    const id = frm.id
    const name = frm.name
    const email = frm.email
    const password = frm.password
    const age = frm.age
    let isValid = true
	
	if(id.value=='') {
        alert('아이디는 필수 입력입니다.')
        id.focus()
        isValid=false
    }else
    if(name.value=='') {
        alert('이름은 필수 입력입니다.')
        name.focus()
        isValid=false
    } else

    if(email.value=='') {
        alert('이메일은 필수 입력입니다.')
        email.focus()
        isValid=false
    } else

	//4)이메일은 기호 @ 와 . 을 포함해야 합니다.  .은 마지막 위치 아니어야 합니다.
	//  -> 잘못된 이메일형식체크
	if(email.value.indexOf('@')==-1 || email.value.indexOf('.') == -1 ||
	  email.value.endsWith('.') ) {
		alert('이메일 형식 체크 실패입니다.')
		email.focus()
		isValid=false
	} else

	//5)
    //실제 이메일 주소는 형식이 위의 조건보다 복잡합니다. 계정문자열에 특수기호는 - _ . 만 포함. 
    //                  도메인이름에 기호는 사용못합니다. naver.com O na-ver.com X  333naver.com X(숫자로 시작)
    //복잡한 조건의 유효성검사를 정규식표현으로 할수 있습니다.
    //정규표현식은 전화번호,이메일,패스워드, 한글,영문 입력체크에 활용.
    
    if(regEmail.test(email.value)===false) {		//test메소드는 정규표현식과 입력문자열 비교
        alert('정규표현식 검사 이메일 형식이 아닙니다.')
		email.focus()
		isValid=false
    }else 
*/

/*
정규표현식은   / / 안에 작성. test메소드로 검사.
^ 는 시작지정
$ 는 끝지정
[] 는 [] 안의 문자들중 1개 선택 , [0-9a-zA-Z]는 숫자,영문소문자,영문대문자 중 1개
* 는 0번 이상 문자 반복
[]? 는 [] 안의 문자들이 있는가? 존재여부. 해당 문자가 있을수도 있고 없을수도 있다.
() 는 그룹
{n} 는 n개
{n,m}는 n개 이상, m번 이하
*/

/* 이메일 정규식 함수 */
function CheckEmail(str){
    var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
    if(!reg_email.test(str)) {
        return false;
    }else {
        return true;
    }
}
function func_join() {

    const frm = document.forms[0];
    const userid = frm.userid.value;
    const username = frm.username.value;
    const useremail = frm.useremail.value;
    const userage = frm.userage.value;
    /* 사용자가 실수로 공백을 입력할 경우 공백으로 제거하고 비밀번호만 추출해서 비교  */
    let password = frm.password.value.trim();
    let password2 = frm.password2.value.trim();
    console.log(frm)
    console.log(userid)
    console.log(username)
    console.log(useremail)
    console.log(userage)
    console.log(password)

    /* let 은 값 변경 또는 객체 재할당을 할수 있는 일반적인 변수 */
    let isValid = true		/*유효성 통과 여부를 저장하는 변수*/

    if (userid === '') {
        alert('ID는 필수 입력입니다.');
        frm.userid.focus();
        isValid = false;
    }
    if (username === '') {
        alert('이름은 필수 입력입니다.');
        frm.username.focus();
        isValid = false;
    }
    if (useremail === '') {
        alert('이메일은 필수 입력입니다.');
        frm.useremail.focus();
        isValid = false;
    } else if (!CheckEmail(useremail)) {
        alert('이메일 형식이 잘못되었습니다.');
        frm.useremail.focus();
        isValid = false;
    }
    if (userage <= 15 || userage >= 99) {
        alert('나이는 15~99 범위의 값이어야 합니다.');
        frm.userage.focus();
        isValid = false;
    }
    if (password.length == 0) {
        alert('비밀번호를 입력해주세요');
        frm.password.focus();
        isValid = false;
    }
    if (password2.length == 0) {
        alert('비밀번호를 입력해주세요');
        frm.password2.focus();
        isValid = false;
    }
    /* 첫번째 입력한 비밀번호와 비밀번호 확인하는 두번째 비밀번호와 일치하는지 확인 */
    if (password2 != password) {
        alert('비밀번호 확인이 일치하지 않습니다.');
        frm.password2.focus();
        isValid = false;
    }
    if (isValid) {
        frm.submit();
    } else {
        alert('회원가입 실패');
    }
}