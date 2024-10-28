$(function () {
    $("#fileupload").fileupload({
        dataType: "json", add: function (e, data) {
            data.context = $('<p class="file">')
                .append($('<a target="_blank">').text(data.files[0].name + " upload success! "))
                .appendTo($('#fileupload-notice'));
            data.submit();
        }, progress: function (e, data) {
            var progress = parseInt((data.loaded / data.total) * 100, 10);
            data.context.css("background-position-x", 100 - progress + "%");
        }, done: function (e, data) {
            data.context
                .addClass("done")
                .find("a")
                .prop("href", data.result.url);
        }
    });

    $("#wowslider-container").wowSlider({
        effect: "rotate",
        prev: "",
        next: "",
        duration: 20 * 100,
        delay: 20 * 100,
        width: 580,
        height: 212,
        autoPlay: true,
        stopOnHover: false,
        loop: false,
        bullets: true,
        caption: true,
        captionEffect: "slide",
        controls: true,
        logo: "",
        images: 0
    });
});