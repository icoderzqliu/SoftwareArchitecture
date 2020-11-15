// banner效果
{
    $(".banner_nav li").each(function(){
        let index=$(this).index();
        $(this).mouseenter(function(){
            $(".banner_tanchu1").eq(index).show();
        })
        $(this).mouseleave(function(){
            $(".banner_tanchu1").eq(index).hide();
        })
    })

    let lunbo=document.querySelectorAll(".lunbo1");
    let imgs=document.querySelectorAll(".banner_imgs1");
    let banner=document.querySelector(".banner_bottom");
    lunbo.forEach(function(ele,index){
        ele.onmouseenter=function(){
            for(let i=0;i<imgs.length;i++){
                lunbo[i].classList.remove("active");
                imgs[i].classList.remove("active1");
            }
            this.classList.add("active");
            imgs[index].classList.add("active1");
            n=index;
        }
    })

    let n=0;
    let t=setInterval(move,3000);
    function move(){
        n++;
        if(n===imgs.length){
            n=0;
        }
        if(n<0){
            n=imgs.length-1;
        }
        for(var i=0;i<imgs.length;i++){
            lunbo[i].classList.remove("active");
            imgs[i].classList.remove("active1");
        }
        lunbo[n].classList.add("active");
        imgs[n].classList.add("active1");
    }
    banner.onmouseenter=function(){
        clearInterval(t);
    }
    banner.onmouseleave=function(){
        t=setInterval(move,3000);
    }

}
// //头部效果
// $(".h_a1").each(function(index,ele){
//     $(this).mouseenter(function(){
//         $(".icon_down").eq(index).hide();
//         $(".icon_up").eq(index).show();
//     })
//     $(this).mouseleave(function(){
//         $(".icon_up").eq(index).hide();
//         $(".icon_down").eq(index).show();
//     })
// })

//天猫超市效果
{
    $(".jrfq_top1").mouseenter(function(){
        var index=$(this).index();
        $(".jrfq_mid11").hide();
        $(".jrfq_mid").show();
        $(this).addClass("active").siblings(".active").removeClass("active");
    })
    $(".jrfq_top11").mouseenter(function(){
        $(".jrfq_mid11").show();
        $(".jrfq_mid").hide();
    })
}
//顶部导航效果
{
    $(window).scroll(function () {
        let st = $(window).scrollTop();
        if (st > 780) {
            $(".fixed_top_nav").show();
        } else {
            $(".fixed_top_nav").hide();
        }
    })
}
//回到顶部效果
$(".totop").click(function(){
    $("html,body").animate({scrollTop:0})
})
//滑动出现导航效果
$(window).scroll(function(){
    let st=$(window).scrollTop();
    if(st>800){
        $(".fixed_nav_left").show();
    }else{
        $(".fixed_nav_left").hide();
    }
})
//左导航效果
$(".f_n_l1").click(function(){
    let index=$(this).index(".f_n_l1");
    let ot=$(".tianmaochaoshi").eq(index).offset().top-1200;
    $("html,body").animate({scrollTop:ot},200)
})
$(window).scroll(function(){
    let st=$(window).scrollTop();
    $(".tianmaochaoshi").each(function(index,ele){
        // console.log(this);
        if(st>=$(this).offset().top-1200){
            $(".f_n_l1").removeClass("active").eq(index).addClass("active");
        }
    })
})
//右导航弹出效果
$(".f_f_nav1").each(function(index,ele){
    $(this).mouseenter(function () {
        $(".f_r_tanchu").eq(index).animate({right: '+35px'}, "500");
        $(".f_r_tanchu").eq(index).show();
        $(".f_r_tanchu_sanjiao").eq(index).show();
        $(".f_r_tanchu_sanjiao").eq(index).animate({right: '+27px'}, "500");
    })
    $(this).mouseleave(function(){
        $(".f_r_tanchu").eq(index).hide();
        $(".f_r_tanchu_sanjiao").eq(index).hide();
    })
})
$(".f_f_nav11").mouseenter(function(){
    $(".tan_ewm").show();
})
$(".f_f_nav11").mouseleave(function(){
    $(".tan_ewm").hide();
})

